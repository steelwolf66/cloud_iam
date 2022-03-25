package com.ztax.iam.auth.controller;

import cn.hutool.json.JSONObject;
import com.ztax.common.constants.TokenConstant;
import com.ztax.common.exception.BizException;
import com.ztax.common.redis.utils.RedisUtils;
import com.ztax.common.result.Result;
import com.ztax.iam.auth.constants.AuthConstants;
import com.ztax.iam.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登出
 */
@RestController
@RequestMapping("/oauth")
@Slf4j
public class LogoutController {

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 用户登出
     * 使用黑名单模式
     * 当token未过期时，缓存到redis（即黑名单），失效时间为（token过期时间戳-当前时间戳）
     * 之后在登录时校验当前token是否在黑名单中
     *
     * @return Result
     */
    @DeleteMapping("/logout")
    public Result logout() {
        // 判断token是否为空
        if (!WebUtils.withToken()) {
            throw new BizException("token不可为空");
        }
        //获取token对象
        JSONObject jsonObject = WebUtils.getJwtPayload();

        // JWT唯一标识
        String jti = jsonObject.getStr(TokenConstant.TOKEN_KEY_JTI);

        // JWT过期时间戳（秒）
        long exp = jsonObject.getLong(TokenConstant.TOKEN_KEY_EXP);

        long currentTimeSeconds = System.currentTimeMillis() / 1000;

        if (exp < currentTimeSeconds) { // token已过期，无需加入黑名单
            return Result.success();
        }
        redisUtils.set(AuthConstants.TOKEN_BLACKLIST_PREFIX + jti, null, (exp - currentTimeSeconds));
        return Result.success("登出成功");
    }
}
