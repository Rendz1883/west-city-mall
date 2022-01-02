package io.github.ireflux.westcitymall.service;

import io.github.ireflux.westcitymall.entity.ProductInfo;
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
public interface IProductInfoService extends IService<ProductInfo> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ProductInfo>
     */
    IPage<ProductInfo> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param productInfo 
     * @return int
     */
    int add(ProductInfo productInfo);

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
     * @param productInfo 
     * @return int
     */
    int updateData(ProductInfo productInfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return ProductInfo
     */
    ProductInfo findById(Long id);
}
