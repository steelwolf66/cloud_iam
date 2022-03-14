package com.ztax.iam.user.entity;

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
@TableName("user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识
     */
    @TableId(value = "user_id", type = IdType.UUID)
    private String userId;

    /**
     * 用户编码/手机号
     */
    @TableField("user_code")
    private String userCode;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 用户密码
     */
    @TableField("password")
    private String password;

    /**
     * 是否启用
     */
    @TableField("enabled")
    private Boolean enabled;

    /**
     * 用户状态\n
     */
    @TableField("status")
    private String status;

    /**
     * 用户邮箱
     */
    @TableField("user_mail")
    private String userMail;

    /**
     * 用户类型
     */
    @TableField("user_type")
    private String userType;

    /**
     * 用户企业id
     */
    @TableField("user_company")
    private String userCompany;

    /**
     * 用户企业名称
     */
    @TableField("user_comp_name")
    private String userCompName;

    /**
     * 创建人
     */
    @TableField("create_id")
    private String createId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @TableField("update_id")
    private String updateId;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 删除人
     */
    @TableField("del_id")
    private String delId;

    /**
     * 删除时间
     */
    @TableField("del_time")
    private LocalDateTime delTime;

    /**
     * 删除标志
     */
    @TableField("del_type")
    private String delType;

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }
    public String getUserCode() {
        return userCode;
    }

    public User setUserCode(String userCode) {
        this.userCode = userCode;
        return this;
    }
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }
    public String getNickname() {
        return nickname;
    }

    public User setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
    public Boolean getEnabled() {
        return enabled;
    }

    public User setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }
    public String getStatus() {
        return status;
    }

    public User setStatus(String status) {
        this.status = status;
        return this;
    }
    public String getUserMail() {
        return userMail;
    }

    public User setUserMail(String userMail) {
        this.userMail = userMail;
        return this;
    }
    public String getUserType() {
        return userType;
    }

    public User setUserType(String userType) {
        this.userType = userType;
        return this;
    }
    public String getUserCompany() {
        return userCompany;
    }

    public User setUserCompany(String userCompany) {
        this.userCompany = userCompany;
        return this;
    }
    public String getUserCompName() {
        return userCompName;
    }

    public User setUserCompName(String userCompName) {
        this.userCompName = userCompName;
        return this;
    }
    public String getCreateId() {
        return createId;
    }

    public User setCreateId(String createId) {
        this.createId = createId;
        return this;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public User setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
    public String getUpdateId() {
        return updateId;
    }

    public User setUpdateId(String updateId) {
        this.updateId = updateId;
        return this;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public User setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
    public String getDelId() {
        return delId;
    }

    public User setDelId(String delId) {
        this.delId = delId;
        return this;
    }
    public LocalDateTime getDelTime() {
        return delTime;
    }

    public User setDelTime(LocalDateTime delTime) {
        this.delTime = delTime;
        return this;
    }
    public String getDelType() {
        return delType;
    }

    public User setDelType(String delType) {
        this.delType = delType;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "User{" +
            "userId=" + userId +
            ", userCode=" + userCode +
            ", username=" + username +
            ", nickname=" + nickname +
            ", password=" + password +
            ", enabled=" + enabled +
            ", status=" + status +
            ", userMail=" + userMail +
            ", userType=" + userType +
            ", userCompany=" + userCompany +
            ", userCompName=" + userCompName +
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
