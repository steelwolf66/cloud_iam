package com.ztax.iam.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ztax.iam.base.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @since 2022-03-14
 */
@TableName("module")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Module extends BaseEntity<Module> {

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
     * 父级id
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 模块类型
     */
    @TableField("module_type")
    private String moduleType;

    /**
     * path
     */
    @TableField("path")
    private String path;

    /**
     * 模块显示顺序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 组件路径
     */
    @TableField("component")
    private String component;

    /**
     * 跳转路径
     */
    @TableField("redirect")
    private String redirect;

    /**
     * 菜单图标【预留字段】
     * 存储图标key，前端进行渲染
     */
    @TableField("icon")
    private String icon;

    /**
     * 是否隐藏
     */
    @TableField("hidden")
    private Boolean hidden;

    /**
     * 模块层级
     */
    @TableField("level")
    private Integer level;

    /**
     * 角色集合
     */
    @TableField("roles")
    private String roles;


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

    /**
     * name for router
     */
    @TableField("name")
    private String name;

    @TableField(exist = false)
    private List<Module> children;

    @TableField(exist = false)
    private Meta meta;
//
//    /**
//     * 创建人
//     */
//    @TableField(value = "create_id", fill = INSERT)
//    private String createId;
//
//    /**
//     * 创建时间
//     */
//    @TableField(value = "create_time", fill = INSERT)
//    private LocalDateTime createTime;
//
//    /**
//     * 修改人
//     */
//    @TableField(value = "update_id", fill = UPDATE)
//    private String updateId;
//
//    /**
//     * 修改时间
//     */
//    @TableField(value = "update_time", fill = UPDATE)
//    private LocalDateTime updateTime;
//
//    /**
//     * 删除人
//     */
//    @TableField(value ="del_id", fill = UPDATE)
//    private String delId;
//
//    /**
//     * 删除时间
//     */
//    @TableField(value = "del_time", fill = UPDATE)
//    private LocalDateTime delTime;
//
//    /**
//     * 删除标志
//     */
//    @TableField("del_flg")
//    @TableLogic(value = "0", delval = "1")
//    private Boolean delFlg;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal;
    }

    public BigDecimal getBaseAmt() {
        return baseAmt;
    }

    public void setBaseAmt(BigDecimal baseAmt) {
        this.baseAmt = baseAmt;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public List<Module> getChildren() {
        return children;
    }

    public void setChildren(List<Module> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    //    public String getCreateId() {
//        return createId;
//    }
//
//    public Module setCreateId(String createId) {
//        this.createId = createId;
//        return this;
//    }
//    public LocalDateTime getCreateTime() {
//        return createTime;
//    }
//
//    public Module setCreateTime(LocalDateTime createTime) {
//        this.createTime = createTime;
//        return this;
//    }
//    public String getUpdateId() {
//        return updateId;
//    }
//
//    public Module setUpdateId(String updateId) {
//        this.updateId = updateId;
//        return this;
//    }
//    public LocalDateTime getUpdateTime() {
//        return updateTime;
//    }
//
//    public Module setUpdateTime(LocalDateTime updateTime) {
//        this.updateTime = updateTime;
//        return this;
//    }
//    public String getDelId() {
//        return delId;
//    }
//
//    public Module setDelId(String delId) {
//        this.delId = delId;
//        return this;
//    }
//    public LocalDateTime getDelTime() {
//        return delTime;
//    }
//
//    public Module setDelTime(LocalDateTime delTime) {
//        this.delTime = delTime;
//        return this;
//    }
//
//    public Boolean getDelFlg() {
//        return delFlg;
//    }
//
//    public void setDelFlg(Boolean delFlg) {
//        this.delFlg = delFlg;
//    }

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
                ", sort=" + sort +
                ", path=" + path +
                ", deal=" + deal +
                ", baseAmt=" + baseAmt +
                ", period=" + period +
                ", userNumber=" + userNumber +
                ", createId=" + super.getCreateId() +
                ", createTime=" + super.getCreateTime() +
                ", updateId=" + super.getUpdateId() +
                ", updateTime=" + super.getUpdateTime() +
                ", delId=" + super.getDelId() +
                ", delTime=" + super.getDelTime() +
                ", delFlg=" + super.getDelFlg() +
                "}";
    }

}
