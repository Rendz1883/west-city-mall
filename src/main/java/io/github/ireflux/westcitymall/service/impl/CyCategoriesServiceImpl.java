package io.github.ireflux.westcitymall.service.impl;

import io.github.ireflux.westcitymall.entity.CyCategories;
import io.github.ireflux.westcitymall.mapper.CyCategoriesMapper;
import io.github.ireflux.westcitymall.service.ICyCategoriesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
@Service
public class CyCategoriesServiceImpl extends ServiceImpl<CyCategoriesMapper, CyCategories> implements ICyCategoriesService {

    @Override
    public  IPage<CyCategories> findListByPage(Integer current, Integer pageSize){
        IPage<CyCategories> wherePage = new Page<>(current, pageSize);
        CyCategories where = new CyCategories();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(CyCategories cyCategories){
        return baseMapper.insert(cyCategories);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(CyCategories cyCategories){
        return baseMapper.updateById(cyCategories);
    }

    @Override
    public CyCategories findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public int addAll(List<CyCategories> cyCategoriesList) {
        return baseMapper.insertAll(cyCategoriesList);
    }
}
