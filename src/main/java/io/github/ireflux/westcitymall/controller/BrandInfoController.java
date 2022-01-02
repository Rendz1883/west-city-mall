package io.github.ireflux.westcitymall.controller;

import io.github.ireflux.westcitymall.service.IBrandInfoService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.github.ireflux.westcitymall.entity.BrandInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-01
 */
@Api(tags = "品牌信息接口")
@RestController
@RequestMapping("/westcitymall/brand-info")
public class BrandInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private IBrandInfoService brandInfoService;

    @Operation(summary = "添加单个商品")
    @PostMapping()
    public int add(@RequestBody BrandInfo brandInfo){
        return brandInfoService.add(brandInfo);
    }

    @Operation(summary = "删除单个商品")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return brandInfoService.delete(id);
    }

    @Operation(summary = "更新单个商品")
    @PutMapping()
    public int update(@RequestBody BrandInfo brandInfo){
        return brandInfoService.updateData(brandInfo);
    }

    @Operation(summary = "分页查询商品")
    @GetMapping()
    public IPage<BrandInfo> findListByPage(@RequestParam Integer current, @RequestParam Integer pageSize){
        return brandInfoService.findListByPage(current, pageSize);
    }

    @Operation(summary = "查询单个商品")
    @GetMapping("{id}")
    public BrandInfo findById(@PathVariable Long id){
        return brandInfoService.findById(id);
    }




}
