package com.ztax.iam.company.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT;
import static com.baomidou.mybatisplus.annotation.FieldFill.UPDATE;

/**
 * <p>
    * 
    * </p>
 *
 * @since 2022-03-15
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

    /**
     * 创建人
     */
    @TableField(value = "create_id", fill = INSERT)
    private String createId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = INSERT)
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @TableField(value = "update_id", fill = UPDATE)
    private String updateId;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = UPDATE)
    private LocalDateTime updateTime;

    /**
     * 删除人
     */
    @TableField(value ="del_id", fill = UPDATE)
    private String delId;

    /**
     * 删除时间
     */
    @TableField(value = "del_time", fill = UPDATE)
    private LocalDateTime delTime;

    /**
     * 删除标志
     */
    @TableField("del_flg")
    @TableLogic(value = "0", delval = "1")
    private Boolean delFlg;

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

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
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
            ", delFlg=" + delFlg +
        "}";
    }

}
