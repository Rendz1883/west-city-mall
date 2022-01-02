package io.github.ireflux.westcitymall.service.impl;

import io.github.ireflux.westcitymall.entity.StaffInfo;
import io.github.ireflux.westcitymall.mapper.StaffInfoMapper;
import io.github.ireflux.westcitymall.service.IStaffInfoService;
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
public class StaffInfoServiceImpl extends ServiceImpl<StaffInfoMapper, StaffInfo> implements IStaffInfoService {

    @Override
    public  IPage<StaffInfo> findListByPage(Integer current, Integer pageSize){
        IPage<StaffInfo> wherePage = new Page<>(current, pageSize);
        StaffInfo where = new StaffInfo();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(StaffInfo staffInfo){
        return baseMapper.insert(staffInfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(StaffInfo staffInfo){
        return baseMapper.updateById(staffInfo);
    }

    @Override
    public StaffInfo findById(Long id){
        return  baseMapper.selectById(id);
    }
}
