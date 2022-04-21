package com.ztax.iam.assignment.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
    * 
    * </p>
 *
 * @since 2022-03-14
 */
@TableName("user_module_rel")
public class UserModuleRel extends Model<UserModuleRel> {

    private static final long serialVersionUID = 1L;

    @TableField("user_id")
    private String userId;

    @TableField("module_id")
    private String moduleId;

    @TableField("end_time")
    private LocalDateTime endTime;

    @TableField("user_num")
    private Integer userNum;

    public String getUserId() {
        return userId;
    }

    public UserModuleRel setUserId(String userlId) {
        this.userId = userlId;
        return this;
    }
    public String getModuleId() {
        return moduleId;
    }

    public UserModuleRel setModuleId(String moduleId) {
        this.moduleId = moduleId;
        return this;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public UserModuleRel setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }
    public Integer getUserNum() {
        return userNum;
    }

    public UserModuleRel setUserNum(Integer userNum) {
        this.userNum = userNum;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "UserModuleRel{" +
            "userId=" + userId +
            ", moduleId=" + moduleId +
            ", endTime=" + endTime +
            ", userNum=" + userNum +
        "}";
    }
}
