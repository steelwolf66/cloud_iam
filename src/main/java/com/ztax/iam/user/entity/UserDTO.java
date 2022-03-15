package com.ztax.iam.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {

    private String userId;
    private String username;
    private String password;
    private String status;
    private String clientId;
    private List<String> moduleIds;;

}