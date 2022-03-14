package com.ztax.iam.module.entity;

import java.math.BigDecimal;
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
@TableName("module")
public class Module extends Model<Module> {

    private static final long serialVersionUID = 1L;

    /**
     * 模块唯一标识
     */
    @TableId(value = "module_id", type = IdType.UUID)
    private String moduleId;

    /**
     * 模块名称
     */
    @TableField("module_name")
    private String moduleName;

    /**
     * 模块类型
     */
    @TableField("module_type")
    private String moduleType;

    /**
     * 模块显示顺序
     */
    @TableField("module_no")
    private Integer moduleNo;

    /**
     * url路径
     */
    @TableField("url")
    private String url;

    /**
     * 特殊处理转换
     */
    @TableField("deal")
    private String deal;

    /**
     * 基础金额
     */
    @TableField("base_amt")
    private BigDecimal baseAmt;

    /**
     * 周期
     */
    @TableField("period")
    private String period;

    /**
     * 用户数量
     */
    @TableField("user_number")
    private Integer userNumber;

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

    public String getModuleId() {
        return moduleId;
    }

    public Module setModuleId(String moduleId) {
        this.moduleId = moduleId;
        return this;
    }
    public String getModuleName() {
        return moduleName;
    }

    public Module setModuleName(String moduleName) {
        this.moduleName = moduleName;
        return this;
    }
    public String getModuleType() {
        return moduleType;
    }

    public Module setModuleType(String moduleType) {
        this.moduleType = moduleType;
        return this;
    }
    public Integer getModuleNo() {
        return moduleNo;
    }

    public Module setModuleNo(Integer moduleNo) {
        this.moduleNo = moduleNo;
        return this;
    }
    public String getUrl() {
        return url;
    }

    public Module setUrl(String url) {
        this.url = url;
        return this;
    }
    public String getDeal() {
        return deal;
    }

    public Module setDeal(String deal) {
        this.deal = deal;
        return this;
    }
    public BigDecimal getBaseAmt() {
        return baseAmt;
    }

    public Module setBaseAmt(BigDecimal baseAmt) {
        this.baseAmt = baseAmt;
        return this;
    }
    public String getPeriod() {
        return period;
    }

    public Module setPeriod(String period) {
        this.period = period;
        return this;
    }
    public Integer getUserNumber() {
        return userNumber;
    }

    public Module setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
        return this;
    }
    public String getCreateId() {
        return createId;
    }

    public Module setCreateId(String createId) {
        this.createId = createId;
        return this;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Module setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
    public String getUpdateId() {
        return updateId;
    }

    public Module setUpdateId(String updateId) {
        this.updateId = updateId;
        return this;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public Module setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
    public String getDelId() {
        return delId;
    }

    public Module setDelId(String delId) {
        this.delId = delId;
        return this;
    }
    public LocalDateTime getDelTime() {
        return delTime;
    }

    public Module setDelTime(LocalDateTime delTime) {
        this.delTime = delTime;
        return this;
    }
    public String getDelType() {
        return delType;
    }

    public Module setDelType(String delType) {
        this.delType = delType;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.moduleId;
    }

    @Override
    public String toString() {
        return "Module{" +
            "moduleId=" + moduleId +
            ", moduleName=" + moduleName +
            ", moduleType=" + moduleType +
            ", moduleNo=" + moduleNo +
            ", url=" + url +
            ", deal=" + deal +
            ", baseAmt=" + baseAmt +
            ", period=" + period +
            ", userNumber=" + userNumber +
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
