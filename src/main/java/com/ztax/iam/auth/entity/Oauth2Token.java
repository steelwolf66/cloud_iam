package com.ztax.iam.auth.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 本地token对象
 */
@Data
@Builder
public class Oauth2Token {

    // 访问令牌
    private String accessToken;

    // 刷新令牌
    private String refreshToken;

    // 有效时间(秒)
    private int expiresIn;

}