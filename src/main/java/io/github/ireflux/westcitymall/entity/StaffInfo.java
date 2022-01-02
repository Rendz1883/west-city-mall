package io.github.ireflux.westcitymall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
@TableName("staff_info")
public class StaffInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("员工姓名")
    private String staffName;

    @ApiModelProperty("员工性别")
    private String staffSex;

    @ApiModelProperty("创建时间")
    private LocalDateTime staffCreateDate;

    @ApiModelProperty("更新时间")
    private LocalDateTime staffUpdateDate;

    @ApiModelProperty("手机号")
    private Long staffPhone;

    @ApiModelProperty("身份证类型")
    private Integer identityCardType;

    @ApiModelProperty("身份证编号")
    private String identityCardNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }
    public LocalDateTime getStaffCreateDate() {
        return staffCreateDate;
    }

    public void setStaffCreateDate(LocalDateTime staffCreateDate) {
        this.staffCreateDate = staffCreateDate;
    }
    public LocalDateTime getStaffUpdateDate() {
        return staffUpdateDate;
    }

    public void setStaffUpdateDate(LocalDateTime staffUpdateDate) {
        this.staffUpdateDate = staffUpdateDate;
    }
    public Long getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(Long staffPhone) {
        this.staffPhone = staffPhone;
    }
    public Integer getIdentityCardType() {
        return identityCardType;
    }

    public void setIdentityCardType(Integer identityCardType) {
        this.identityCardType = identityCardType;
    }
    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    @Override
    public String toString() {
        return "StaffInfo{" +
            "id=" + id +
            ", staffName=" + staffName +
            ", staffSex=" + staffSex +
            ", staffCreateDate=" + staffCreateDate +
            ", staffUpdateDate=" + staffUpdateDate +
            ", staffPhone=" + staffPhone +
            ", identityCardType=" + identityCardType +
            ", identityCardNo=" + identityCardNo +
        "}";
    }
}