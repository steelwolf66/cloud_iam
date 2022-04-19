package com.ztax.iam.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT;
import static com.baomidou.mybatisplus.annotation.FieldFill.UPDATE;

@Data
public class BaseEntity<T extends Model<?>> extends Model<T> {
    @TableField(exist = false)
    private Integer pageNo;

    @TableField(exist = false)
    private Integer pageSize;

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
    @TableField(value = "del_id", fill = UPDATE)
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
}
