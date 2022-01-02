package io.github.ireflux.westcitymall.controller;

import org.springframework.web.bind.annotation.*;
import io.github.ireflux.westcitymall.service.IStaffInfoService;
import io.github.ireflux.westcitymall.entity.StaffInfo;
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
 * @since 2022-01-02
 */
@Controller
@RequestMapping("/westcitymall/staff-info")
public class StaffInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IStaffInfoService staffInfoService;

    @PostMapping()
    public int add(@RequestBody StaffInfo staffInfo){
        return staffInfoService.add(staffInfo);
    }

    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return staffInfoService.delete(id);
    }

    @PutMapping()
    public int update(@RequestBody StaffInfo staffInfo){
        return staffInfoService.updateData(staffInfo);
    }

    @GetMapping()
    public IPage<StaffInfo> findListByPage(@RequestParam Integer current,
                                   @RequestParam Integer pageSize){
        return staffInfoService.findListByPage(current, pageSize);
    }

    @GetMapping("{id}")
    public StaffInfo findById(@PathVariable Long id){
        return staffInfoService.findById(id);
    }

}
