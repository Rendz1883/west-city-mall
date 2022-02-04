package io.github.ireflux.westcitymall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-01
 */
@ApiModel("品牌实体类VO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @NotBlank(message = "品牌名称不能为空")
    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("品牌url")
    private String brandUrlId;

    @ApiModelProperty("品牌描述")
    private String brandDesc;

    @ApiModelProperty("品牌状态")
    private String brandStatus;

    @ApiModelProperty("创建时间")
    private LocalDateTime brandCreateDate;

    @ApiModelProperty("更新时间")
    private LocalDateTime brandUpdateDate;

    @ApiModelProperty("更新人ID")
    private Long brandUpdateStaffId;

}