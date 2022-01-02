package io.github.ireflux.westcitymall.service.impl;

import io.github.ireflux.westcitymall.entity.BrandInfo;
import io.github.ireflux.westcitymall.mapper.BrandInfoMapper;
import io.github.ireflux.westcitymall.service.IBrandInfoService;
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
 * @since 2022-01-01
 */
@Service
public class BrandInfoServiceImpl extends ServiceImpl<BrandInfoMapper, BrandInfo> implements IBrandInfoService {

    @Override
    public  IPage<BrandInfo> findListByPage(Integer page, Integer pageCount){
        IPage<BrandInfo> wherePage = new Page<>(page, pageCount);
        BrandInfo where = new BrandInfo();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(BrandInfo brandInfo){
        return baseMapper.insert(brandInfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(BrandInfo brandInfo){
        return baseMapper.updateById(brandInfo);
    }

    @Override
    public BrandInfo findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public String brandFindNameById(int id) {
        return baseMapper.selectNameById(id);
    }


}
