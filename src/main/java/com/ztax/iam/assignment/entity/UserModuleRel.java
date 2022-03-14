package com.ztax.iam.assignment.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

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

    @TableField("userl_id")
    private String userlId;

    @TableField("module_id")
    private String moduleId;

    @TableField("end_time")
    private LocalDateTime endTime;

    @TableField("user_num")
    private Integer userNum;

    public String getUserlId() {
        return userlId;
    }

    public UserModuleRel setUserlId(String userlId) {
        this.userlId = userlId;
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
            "userlId=" + userlId +
            ", moduleId=" + moduleId +
            ", endTime=" + endTime +
            ", userNum=" + userNum +
        "}";
    }

}