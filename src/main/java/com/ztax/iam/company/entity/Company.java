package com.ztax.iam.company.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.ztax.iam.base.entity.BaseEntity;

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
public class Company extends BaseEntity<Company> {

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
        "}";
    }

}
