package io.github.ireflux.westcitymall.controller;

import io.github.ireflux.westcitymall.base.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.github.ireflux.westcitymall.service.IProductInfoService;
import io.github.ireflux.westcitymall.entity.ProductInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
@Api(value = "产品信息接口", tags = "产品信息")
@RestController
@RequestMapping("/westcitymall/product-info")
public class ProductInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private IProductInfoService productInfoService;

    @Operation(summary = "添加产品")
    @PostMapping()
    public ApiResult add(@Valid @RequestBody ProductInfo productInfo){
        return ApiResult.success(productInfoService.add(productInfo));
    }

    @Operation(summary = "删除产品")
    @DeleteMapping("{id}")
    public ApiResult delete(@PathVariable("id") Long id){
        return ApiResult.success(productInfoService.delete(id));
    }

    @Operation(summary = "修改产品")
    @PutMapping()
    public ApiResult update(@Valid @RequestBody ProductInfo productInfo){
        return ApiResult.success(productInfoService.updateData(productInfo));
    }

    @Operation(summary = "产品分页查询")
    @GetMapping()
    public ApiResult findListByPage(@RequestParam Integer current,
                                   @RequestParam Integer pageSize){
        return ApiResult.success(productInfoService.findListByPage(current, pageSize));
    }

    @Operation(summary = "查询单个产品")
    @GetMapping("{id}")
    public ApiResult findById(@PathVariable Long id){
        return ApiResult.success(productInfoService.findById(id));
    }

}
