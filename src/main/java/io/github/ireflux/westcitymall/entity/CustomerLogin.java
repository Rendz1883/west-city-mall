package io.github.ireflux.westcitymall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户登录表
 * </p>
 *
 * @author zhaoxinyang
 * @since 2022-01-02
 */
@TableName("customer_login")
public class CustomerLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "customer_id", type = IdType.AUTO)
    private Integer customerId;

    private String loginName;

    private String password;

    private String telephone;

    private Integer userStats;

    private LocalDateTime modifiedTime;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getUserStats() {
        return userStats;
    }

    public void setUserStats(Integer userStats) {
        this.userStats = userStats;
    }
    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "CustomerLogin{" +
            "customerId=" + customerId +
            ", loginName=" + loginName +
            ", password=" + password +
            ", telephone=" + telephone +
            ", userStats=" + userStats +
            ", modifiedTime=" + modifiedTime +
        "}";
    }




}