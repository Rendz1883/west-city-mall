package io.github.ireflux.westcitymall.mapper;

import io.github.ireflux.westcitymall.entity.CustomerLogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户登录表 Mapper 接口
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
public interface CustomerLoginMapper extends BaseMapper<CustomerLogin> {

    CustomerLogin selectByName(String loginName);
}
