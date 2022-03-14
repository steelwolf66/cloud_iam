package com.ztax.iam.company.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
    * 
    * </p>
 *
 * @since 2022-03-14
 */
@TableName("company")
public class Company extends Model<Company> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "company_id", type = IdType.UUID)
    private String companyId;

    @TableField("company_name")
    private String companyName;

    @TableField("company_identify")
    private String companyIdentify;

    @TableField("address")
    private String address;

    @TableField("company_type")
    private String companyType;

    @TableField("phone")
    private String phone;

    @TableField("fax")
    private String fax;

    @TableField("create_id")
    private String createId;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_id")
    private String updateId;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("del_id")
    private String delId;

    @TableField("del_time")
    private LocalDateTime delTime;

    @TableField("del_type")
    private String delType;

    public String getCompanyId() {
        return companyId;
    }

    public Company setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }
    public String getCompanyName() {
        return companyName;
    }

    public Company setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }
    public String getCompanyIdentify() {
        return companyIdentify;
    }

    public Company setCompanyIdentify(String companyIdentify) {
        this.companyIdentify = companyIdentify;
        return this;
    }
    public String getAddress() {
        return address;
    }

    public Company setAddress(String address) {
        this.address = address;
        return this;
    }
    public String getCompanyType() {
        return companyType;
    }

    public Company setCompanyType(String companyType) {
        this.companyType = companyType;
        return this;
    }
    public String getPhone() {
        return phone;
    }

    public Company setPhone(String phone) {
        this.phone = phone;
        return this;
    }
    public String getFax() {
        return fax;
    }

    public Company setFax(String fax) {
        this.fax = fax;
        return this;
    }
    public String getCreateId() {
        return createId;
    }

    public Company setCreateId(String createId) {
        this.createId = createId;
        return this;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Company setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
    public String getUpdateId() {
        return updateId;
    }

    public Company setUpdateId(String updateId) {
        this.updateId = updateId;
        return this;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public Company setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
    public String getDelId() {
        return delId;
    }

    public Company setDelId(String delId) {
        this.delId = delId;
        return this;
    }
    public LocalDateTime getDelTime() {
        return delTime;
    }

    public Company setDelTime(LocalDateTime delTime) {
        this.delTime = delTime;
        return this;
    }
    public String getDelType() {
        return delType;
    }

    public Company setDelType(String delType) {
        this.delType = delType;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.companyId;
    }

    @Override
    public String toString() {
        return "Company{" +
            "companyId=" + companyId +
            ", companyName=" + companyName +
            ", companyIdentify=" + companyIdentify +
            ", address=" + address +
            ", companyType=" + companyType +
            ", phone=" + phone +
            ", fax=" + fax +
            ", createId=" + createId +
            ", createTime=" + createTime +
            ", updateId=" + updateId +
            ", updateTime=" + updateTime +
            ", delId=" + delId +
            ", delTime=" + delTime +
            ", delType=" + delType +
        "}";
    }

}
