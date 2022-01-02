package io.github.ireflux.westcitymall.mapper;

import io.github.ireflux.westcitymall.entity.CyCategories;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
public interface CyCategoriesMapper extends BaseMapper<CyCategories> {

    int insertAll(List<CyCategories> cyCategoriesList);
}
