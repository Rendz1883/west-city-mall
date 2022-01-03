package io.github.ireflux.westcitymall.service.impl;

import io.github.ireflux.westcitymall.entity.CustomerLogin;
import io.github.ireflux.westcitymall.mapper.CustomerLoginMapper;
import io.github.ireflux.westcitymall.service.ICustomerLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 用户登录表 服务实现类
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
@Service
public class CustomerLoginServiceImpl extends ServiceImpl<CustomerLoginMapper, CustomerLogin> implements ICustomerLoginService {

    @Override
    public  IPage<CustomerLogin> findListByPage(Integer current, Integer pageSize){
        IPage<CustomerLogin> wherePage = new Page<>(current, pageSize);
        CustomerLogin where = new CustomerLogin();

        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(CustomerLogin customerLogin){
        return baseMapper.insert(customerLogin);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(CustomerLogin customerLogin){
        return baseMapper.updateById(customerLogin);
    }

    @Override
    public CustomerLogin findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public CustomerLogin findByName(String loginName) {
        return baseMapper.selectByName(loginName);
    }

    @Override
    public void updateByLoginStatic(CustomerLogin customerLogin) {
            baseMapper.updateByStatic(customerLogin);
    }
}
