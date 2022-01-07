package io.github.ireflux.westcitymall.controller;


import cn.hutool.json.JSONObject;
import io.github.ireflux.westcitymall.base.ApiResult;
import io.github.ireflux.westcitymall.entity.CustomerLogin;
import io.github.ireflux.westcitymall.service.ICustomerLoginService;
import io.github.ireflux.westcitymall.tokenAnnotation.PassToken;
import io.github.ireflux.westcitymall.tokenAnnotation.UserLoginToken;
import io.github.ireflux.westcitymall.util.FileDfsUtil;
import io.github.ireflux.westcitymall.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Disembark")
public class DisembarkController {

    @Autowired
    private ICustomerLoginService customerLoginService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private FileDfsUtil dfsUtil;



    //登录
    @PostMapping("/login")
    public Object login(@RequestBody CustomerLogin customerLogin){
        JSONObject jsonObject=new JSONObject();
        CustomerLogin customerLoginBase=customerLoginService.findByName(customerLogin.getLoginName());
        if(customerLoginBase==null){
            jsonObject.putOpt("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!customerLoginBase.getPassword().equals(customerLogin.getPassword())){
                jsonObject.putOpt("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = TokenUtil.getToken(customerLoginBase);
                stringRedisTemplate.opsForValue().set(customerLoginBase.getLoginName(),token);
                jsonObject.putOpt("token", token);
                jsonObject.putOpt("user", customerLoginBase);
                customerLoginService.updateByLoginStatic(customerLoginBase);
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

    //退出登录
    @UserLoginToken
    @PutMapping("/sigOut")
    public ApiResult signOut(@RequestBody CustomerLogin customerLogin){


         CustomerLogin customer= customerLoginService.findByName(customerLogin.getLoginName());

         if (0 == customer.getUserStats()){

               return ApiResult.fail("请登陆",null);

         }else{
                //1删除redis
                stringRedisTemplate.delete(customerLogin.getLoginName());
                //修改登陆状态
                customerLoginService.updateByQuitStatic(customerLogin);

                return ApiResult.success("用户："+customerLogin.getLoginName()+"退出成功",null);
         }


    }

    @PassToken
    @GetMapping("/fdfsUpload")
    public void fdfsUpload() throws Exception {

        dfsUtil.upload();


    }






}
