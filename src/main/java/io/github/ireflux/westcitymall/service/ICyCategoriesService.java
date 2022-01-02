package io.github.ireflux.westcitymall.service;

import io.github.ireflux.westcitymall.entity.CyCategories;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
public interface ICyCategoriesService extends IService<CyCategories> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<CyCategories>
     */
    IPage<CyCategories> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param cyCategories 
     * @return int
     */
    int add(CyCategories cyCategories);

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
     * @param cyCategories 
     * @return int
     */
    int updateData(CyCategories cyCategories);

    /**
     * id查询数据
     *
     * @param id id
     * @return CyCategories
     */
    CyCategories findById(Long id);

    int addAll(List<CyCategories> cyCategoriesList);
}
