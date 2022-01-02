package io.github.ireflux.westcitymall.controller;

import org.springframework.web.bind.annotation.*;
import io.github.ireflux.westcitymall.service.ICyCategoriesService;
import io.github.ireflux.westcitymall.entity.CyCategories;
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
@RequestMapping("/westcitymall/cy-categories")
public class CyCategoriesController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICyCategoriesService cyCategoriesService;

    @PostMapping()
    public int add(@RequestBody CyCategories cyCategories){
        return cyCategoriesService.add(cyCategories);
    }

    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return cyCategoriesService.delete(id);
    }

    @PutMapping()
    public int update(@RequestBody CyCategories cyCategories){
        return cyCategoriesService.updateData(cyCategories);
    }

    @GetMapping()
    public IPage<CyCategories> findListByPage(@RequestParam Integer current,
                                   @RequestParam Integer pageSize){
        return cyCategoriesService.findListByPage(current, pageSize);
    }

    @GetMapping("{id}")
    public CyCategories findById(@PathVariable Long id){
        return cyCategoriesService.findById(id);
    }

}
