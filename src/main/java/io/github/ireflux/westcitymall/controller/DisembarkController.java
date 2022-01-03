package io.github.ireflux.westcitymall.controller;


import cn.hutool.json.JSONObject;
import io.github.ireflux.westcitymall.entity.CustomerLogin;
import io.github.ireflux.westcitymall.service.ICustomerLoginService;
import io.github.ireflux.westcitymall.tokenAnnotation.UserLoginToken;
import io.github.ireflux.westcitymall.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Disembark")
public class DisembarkController {

    @Autowired
    ICustomerLoginService customerLoginService;

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

    //退出








}
