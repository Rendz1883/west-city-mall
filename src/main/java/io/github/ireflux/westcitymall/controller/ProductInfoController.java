package io.github.ireflux.westcitymall.controller;

import org.springframework.web.bind.annotation.*;
import io.github.ireflux.westcitymall.service.IProductInfoService;
import io.github.ireflux.westcitymall.entity.ProductInfo;
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
@RequestMapping("/westcitymall/product-info")
public class ProductInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IProductInfoService productInfoService;

    @PostMapping()
    public int add(@RequestBody ProductInfo productInfo){
        return productInfoService.add(productInfo);
    }

    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return productInfoService.delete(id);
    }

    @PutMapping()
    public int update(@RequestBody ProductInfo productInfo){
        return productInfoService.updateData(productInfo);
    }

    @GetMapping()
    public IPage<ProductInfo> findListByPage(@RequestParam Integer current,
                                   @RequestParam Integer pageSize){
        return productInfoService.findListByPage(current, pageSize);
    }

    @GetMapping("{id}")
    public ProductInfo findById(@PathVariable Long id){
        return productInfoService.findById(id);
    }

}
