package com.ztax.iam.user.entity;

import lombok.Data;

@Data
public class UserVO extends User {
    private Integer pageNo;
    private Integer pageSize;
}
