package com.ztax.iam.entity;

import lombok.Data;

import java.util.List;

@Data
public class SysUser extends BaseEntity {

    private Long id;

    private String username;

    private String nickname;

    private String mobile;

    private Integer gender;

    private String avatar;

    private String password;

    private Integer status;

    private Long deptId;

    private Integer deleted;

    private String deptName;

    private List<Long> roleIds;

    private String roleNames;

}