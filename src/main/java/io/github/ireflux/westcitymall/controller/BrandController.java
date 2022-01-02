package io.github.ireflux.westcitymall.controller;


import io.github.ireflux.westcitymall.service.IBrandInfoService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Api("品牌信息接口")
@RestController
@RequestMapping("/westcitymall/brand")
public class BrandController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IBrandInfoService brandInfoService;


    @Operation(summary = "品牌名查询")
    @GetMapping("/findNameByid/{id}")
    @ResponseBody
    public String brandNameById(@PathVariable int id){

        return brandInfoService.brandFindNameById(id);

    }





}
