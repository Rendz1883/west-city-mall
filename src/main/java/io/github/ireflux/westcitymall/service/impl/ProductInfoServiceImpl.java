package io.github.ireflux.westcitymall.service.impl;

import io.github.ireflux.westcitymall.entity.ProductInfo;
import io.github.ireflux.westcitymall.mapper.ProductInfoMapper;
import io.github.ireflux.westcitymall.service.IProductInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements IProductInfoService {

    @Override
    public  IPage<ProductInfo> findListByPage(Integer current, Integer pageSize){
        IPage<ProductInfo> wherePage = new Page<>(current, pageSize);
        ProductInfo where = new ProductInfo();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ProductInfo productInfo){
        return baseMapper.insert(productInfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ProductInfo productInfo){
        return baseMapper.updateById(productInfo);
    }

    @Override
    public ProductInfo findById(Long id){
        return  baseMapper.selectById(id);
    }
}
