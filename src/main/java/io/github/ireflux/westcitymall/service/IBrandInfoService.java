package io.github.ireflux.westcitymall.service;

import io.github.ireflux.westcitymall.entity.BrandInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-01
 */
public interface IBrandInfoService extends IService<BrandInfo> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<BrandInfo>
     */
    IPage<BrandInfo> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param brandInfo 
     * @return int
     */
    int add(BrandInfo brandInfo);

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
     * @param brandInfo 
     * @return int
     */
    int updateData(BrandInfo brandInfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return BrandInfo
     */
    BrandInfo findById(Long id);
}
