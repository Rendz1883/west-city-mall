package io.github.ireflux.westcitymall.controller;

import io.github.ireflux.westcitymall.base.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.github.ireflux.westcitymall.service.ICustomerLoginService;
import io.github.ireflux.westcitymall.entity.CustomerLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 用户登录表 前端控制器
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
@RestController
@RequestMapping("/westcitymall/customer-login")
public class CustomerLoginController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICustomerLoginService customerLoginService;

    @PostMapping()
    public ApiResult add(@RequestBody CustomerLogin customerLogin){
        return ApiResult.success(customerLoginService.add(customerLogin));
    }

    @DeleteMapping("{id}")
    public ApiResult delete(@PathVariable("id") Long id){
        return ApiResult.success(customerLoginService.delete(id));
    }

    @PutMapping()
    public ApiResult update(@RequestBody CustomerLogin customerLogin){
        return ApiResult.success(customerLoginService.updateData(customerLogin));
    }

    @GetMapping()
    public ApiResult findListByPage(@RequestParam Integer current,
                                   @RequestParam Integer pageSize){
        return ApiResult.success(customerLoginService.findListByPage(current, pageSize));
    }

    @GetMapping("{id}")
    public ApiResult findById(@PathVariable Long id){
        return ApiResult.success(customerLoginService.findById(id));
    }

}
