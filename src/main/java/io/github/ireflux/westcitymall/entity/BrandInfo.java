package io.github.ireflux.westcitymall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@ApiModel("品牌实体类")
@TableName("brand_info")
public class BrandInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getBrandUrlId() {
        return brandUrlId;
    }

    public void setBrandUrlId(String brandUrlId) {
        this.brandUrlId = brandUrlId;
    }
    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }
    public String getBrandStatus() {
        return brandStatus;
    }

    public void setBrandStatus(String brandStatus) {
        this.brandStatus = brandStatus;
    }
    public LocalDateTime getBrandCreateDate() {
        return brandCreateDate;
    }

    public void setBrandCreateDate(LocalDateTime brandCreateDate) {
        this.brandCreateDate = brandCreateDate;
    }
    public LocalDateTime getBrandUpdateDate() {
        return brandUpdateDate;
    }

    public void setBrandUpdateDate(LocalDateTime brandUpdateDate) {
        this.brandUpdateDate = brandUpdateDate;
    }
    public Long getBrandUpdateStaffId() {
        return brandUpdateStaffId;
    }

    public void setBrandUpdateStaffId(Long brandUpdateStaffId) {
        this.brandUpdateStaffId = brandUpdateStaffId;
    }

    @Override
    public String toString() {
        return "BrandInfo{" +
            "id=" + id +
            ", brandName=" + brandName +
            ", brandUrlId=" + brandUrlId +
            ", brandDesc=" + brandDesc +
            ", brandStatus=" + brandStatus +
            ", brandCreateDate=" + brandCreateDate +
            ", brandUpdateDate=" + brandUpdateDate +
            ", brandUpdateStaffId=" + brandUpdateStaffId +
        "}";
    }
}