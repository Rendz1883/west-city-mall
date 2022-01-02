package io.github.ireflux.westcitymall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
@TableName("product_info")
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("产品名称")
    private String productName;

    private String productCore;

    private Long brandId;

    private Integer oneCategoryId;

    private Integer twoCategoryId;

    private Integer threeCategoryId;

    private Long supplierId;

    private BigDecimal price;

    private LocalDateTime productCreateDate;

    private LocalDateTime productUpdateDate;

    private Long productUpdateStaffId;

    private String unique;

    private Integer publishStatus;

    private Integer auditStatus;

    private Float weight;

    private Float length;

    private Float height;

    private LocalDateTime productionDate;

    private Integer colorType;

    private String descript;

    private Integer shelfLife;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductCore() {
        return productCore;
    }

    public void setProductCore(String productCore) {
        this.productCore = productCore;
    }
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    public Integer getOneCategoryId() {
        return oneCategoryId;
    }

    public void setOneCategoryId(Integer oneCategoryId) {
        this.oneCategoryId = oneCategoryId;
    }
    public Integer getTwoCategoryId() {
        return twoCategoryId;
    }

    public void setTwoCategoryId(Integer twoCategoryId) {
        this.twoCategoryId = twoCategoryId;
    }
    public Integer getThreeCategoryId() {
        return threeCategoryId;
    }

    public void setThreeCategoryId(Integer threeCategoryId) {
        this.threeCategoryId = threeCategoryId;
    }
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public LocalDateTime getProductCreateDate() {
        return productCreateDate;
    }

    public void setProductCreateDate(LocalDateTime productCreateDate) {
        this.productCreateDate = productCreateDate;
    }
    public LocalDateTime getProductUpdateDate() {
        return productUpdateDate;
    }

    public void setProductUpdateDate(LocalDateTime productUpdateDate) {
        this.productUpdateDate = productUpdateDate;
    }
    public Long getProductUpdateStaffId() {
        return productUpdateStaffId;
    }

    public void setProductUpdateStaffId(Long productUpdateStaffId) {
        this.productUpdateStaffId = productUpdateStaffId;
    }
    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }
    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }
    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }
    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }
    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }
    public LocalDateTime getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDateTime productionDate) {
        this.productionDate = productionDate;
    }
    public Integer getColorType() {
        return colorType;
    }

    public void setColorType(Integer colorType) {
        this.colorType = colorType;
    }
    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
            "id=" + id +
            ", productName=" + productName +
            ", productCore=" + productCore +
            ", brandId=" + brandId +
            ", oneCategoryId=" + oneCategoryId +
            ", twoCategoryId=" + twoCategoryId +
            ", threeCategoryId=" + threeCategoryId +
            ", supplierId=" + supplierId +
            ", price=" + price +
            ", productCreateDate=" + productCreateDate +
            ", productUpdateDate=" + productUpdateDate +
            ", productUpdateStaffId=" + productUpdateStaffId +
            ", unique=" + unique +
            ", publishStatus=" + publishStatus +
            ", auditStatus=" + auditStatus +
            ", weight=" + weight +
            ", length=" + length +
            ", height=" + height +
            ", productionDate=" + productionDate +
            ", colorType=" + colorType +
            ", descript=" + descript +
            ", shelfLife=" + shelfLife +
        "}";
    }
}