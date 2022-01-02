package io.github.ireflux.westcitymall.controller;

import io.swagger.annotations.Api;
import io.github.ireflux.westcitymall.base.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.github.ireflux.westcitymall.service.ICyCategoriesService;
import io.github.ireflux.westcitymall.entity.CyCategories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
@Api(value = "分类信息接口", tags = "分类信息")
@RestController
@RequestMapping("/westcitymall/cy-categories")
public class CyCategoriesController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICyCategoriesService cyCategoriesService;

    @Operation(summary = "添加分类")
    @PostMapping()
    public ApiResult add(@Valid @RequestBody CyCategories cyCategories){
        return ApiResult.success(cyCategoriesService.add(cyCategories));
    }

    @Operation(summary = "删除分类")
    @DeleteMapping("{id}")
    public ApiResult delete(@PathVariable("id") Long id){
        return ApiResult.success(cyCategoriesService.delete(id));
    }

    @Operation(summary = "修改分类")
    @PutMapping()
    public ApiResult update(@Valid @RequestBody CyCategories cyCategories){
        return ApiResult.success(cyCategoriesService.updateData(cyCategories));
    }

    @Operation(summary = "分类分页查询")
    @GetMapping()
    public ApiResult findListByPage(@RequestParam Integer current,
                                   @RequestParam Integer pageSize){
        return ApiResult.success(cyCategoriesService.findListByPage(current, pageSize));
    }

    @Operation(summary = "查询单个分类")
    @GetMapping("{id}")
    public ApiResult findById(@PathVariable Long id){
        return ApiResult.success(cyCategoriesService.findById(id));
    }


    @PostMapping("/addAll")
    public int addAll(@RequestBody List<CyCategories> cyCategoriesList){
        return cyCategoriesService.addAll(cyCategoriesList);
    }



}
