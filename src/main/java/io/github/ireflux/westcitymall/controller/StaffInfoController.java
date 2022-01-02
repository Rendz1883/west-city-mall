package io.github.ireflux.westcitymall.controller;

import io.github.ireflux.westcitymall.base.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.github.ireflux.westcitymall.service.IStaffInfoService;
import io.github.ireflux.westcitymall.entity.StaffInfo;
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
@Api(value = "员工信息接口", tags = "员工信息")
@RestController
@RequestMapping("/westcitymall/staff-info")
public class StaffInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private IStaffInfoService staffInfoService;

    @Operation(summary = "添加员工")
    @PostMapping()
    public ApiResult add(@Valid @RequestBody StaffInfo staffInfo){
        return ApiResult.success(staffInfoService.add(staffInfo));
    }

    @Operation(summary = "删除员工")
    @DeleteMapping("{id}")
    public ApiResult delete(@PathVariable("id") Long id){
        return ApiResult.success(staffInfoService.delete(id));
    }

    @Operation(summary = "修改员工")
    @PutMapping()
    public ApiResult update(@Valid @RequestBody StaffInfo staffInfo){
        return ApiResult.success(staffInfoService.updateData(staffInfo));
    }

    @Operation(summary = "员工信息分页查询")
    @GetMapping()
    public ApiResult findListByPage(@RequestParam Integer current,
                                   @RequestParam Integer pageSize){
        return ApiResult.success(staffInfoService.findListByPage(current, pageSize));
    }

    @Operation(summary = "查询单个员工")
    @GetMapping("{id}")
    public ApiResult findById(@PathVariable Long id){
        return ApiResult.success(staffInfoService.findById(id));
    }

}
