package com.ztax.iam.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 从数据库中的用户转换为security需要的用户的中间实体
 */
@Data
@NoArgsConstructor
public class UserDTO {

    private String userId;
    private String username;
    private String password;
    private Boolean enabled;
    private String status;
    private String clientId;
    private List<String> moduleIds;

}