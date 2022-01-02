package io.github.ireflux.westcitymall.controller;

import io.github.ireflux.westcitymall.base.ApiResult;
import io.github.ireflux.westcitymall.service.IBrandInfoService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.ireflux.westcitymall.entity.BrandInfo;
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
 * @since 2022-01-01
 */
@Api(value = "品牌信息接口", tags = "品牌信息")
@RestController
@RequestMapping("/westcitymall/brand-info")
public class BrandInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private IBrandInfoService brandInfoService;

    @Operation(method = "POST", summary = "添加单个品牌", description = "添加一个品牌")
    @PostMapping()
    public ApiResult add(@Valid @RequestBody BrandInfo brandInfo){
        return ApiResult.success(brandInfoService.add(brandInfo));
    }

    @Operation(summary = "删除单个品牌")
    @DeleteMapping("{id}")
    public ApiResult delete(@PathVariable("id") Long id){
        return ApiResult.success(brandInfoService.delete(id));
    }

    @Operation(summary = "更新单个品牌")
    @PutMapping()
    public ApiResult update(@RequestBody BrandInfo brandInfo){
        return ApiResult.success(brandInfoService.updateData(brandInfo));
    }

    @Operation(summary = "分页查询品牌")
    @GetMapping()
    public ApiResult findListByPage(@RequestParam Integer current, @RequestParam Integer pageSize){
        return ApiResult.success(brandInfoService.findListByPage(current, pageSize));
    }

    @Operation(summary = "查询单个品牌")
    @GetMapping("{id}")
    public ApiResult findById(@PathVariable Long id){
        return ApiResult.success(brandInfoService.findById(id));
    }

}
