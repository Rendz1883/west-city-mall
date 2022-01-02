package io.github.ireflux.westcitymall.service;

import io.github.ireflux.westcitymall.entity.StaffInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
public interface IStaffInfoService extends IService<StaffInfo> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<StaffInfo>
     */
    IPage<StaffInfo> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param staffInfo 
     * @return int
     */
    int add(StaffInfo staffInfo);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param staffInfo 
     * @return int
     */
    int updateData(StaffInfo staffInfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return StaffInfo
     */
    StaffInfo findById(Long id);
}
