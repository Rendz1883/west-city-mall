package io.github.ireflux.westcitymall.service;

import io.github.ireflux.westcitymall.entity.CustomerLogin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 用户登录表 服务类
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
public interface ICustomerLoginService extends IService<CustomerLogin> {

    /**
     * 查询用户登录表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<CustomerLogin>
     */
    IPage<CustomerLogin> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加用户登录表
     *
     * @param customerLogin 用户登录表
     * @return int
     */
    int add(CustomerLogin customerLogin);

    /**
     * 删除用户登录表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改用户登录表
     *
     * @param customerLogin 用户登录表
     * @return int
     */
    int updateData(CustomerLogin customerLogin);

    /**
     * id查询数据
     *
     * @param id id
     * @return CustomerLogin
     */
    CustomerLogin findById(Long id);

    /**
     * 账号（）用户名）查询数据
     *
     * @param loginName
     * @return CustomerLogin
     */
    CustomerLogin findByName(String loginName);

    void updateByLoginStatic(CustomerLogin customerLogin);
}
