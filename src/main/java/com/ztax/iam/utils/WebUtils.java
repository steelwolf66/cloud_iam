package com.ztax.iam.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.nimbusds.jose.JWSObject;
import com.ztax.common.exception.BizException;
import com.ztax.common.utils.ObjectUtils;
import com.ztax.iam.auth.constants.AuthConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Slf4j
public class WebUtils extends org.springframework.web.util.WebUtils {

    /**
     * 获取httpServletRequest
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 获取token中的对象信息
     *
     * 存在两种情况，一种是通过gateway进入的请求，一种是通过feign（或HTTP请求）内部调用的请求
     * 默认：从header中获取gateway处理后的payload，获取不到
     * 则从request中获取token，重新解析
     *
     * @return JSONObject token载体
     */
    public static JSONObject getJwtPayload() {
        //gateway
        String jwtPayload = getHttpServletRequest().getHeader(AuthConstants.JWT_PAYLOAD_KEY);
        if (ObjectUtils.isNotBlank(jwtPayload)) {
            JSONObject jsonObject = JSONUtil.parseObj(jwtPayload);
            return jsonObject;
        }
        //内部请求；原生：从token获取payload
        String token = getToken().replace(AuthConstants.JWT_TOKEN_PREFIX, Strings.EMPTY);
        JWSObject jwsObject = null;
        try {
            jwsObject = JWSObject.parse(token);
        } catch (ParseException e) {
            log.error("parse token error", e);
            throw new BizException("解析token异常");
        }
        String payload = jwsObject.getPayload().toString();
        JSONObject payloadsonObject = JSONUtil.parseObj(payload);
        return payloadsonObject;
    }

    /**
     * 是否携带token
     * @return
     */
    public static boolean withToken() {
        return ObjectUtils.isNotBlank(getToken());
    }

    /**
     * 获取token
     * @return
     */
    public static String getToken() {
        return getHttpServletRequest().getHeader(AuthConstants.JWT_TOKEN_HEADER);
    }

    /**
     * 获取用户id
     * @return
     */
    public static String getUserId() {
        String id = getJwtPayload().getStr(AuthConstants.JWT_USER_ID_KEY);
        return id;
    }

    /**
     * 获取client id
     * @return
     */
    public static String getClientId() {
        String clientId = getJwtPayload().getStr(AuthConstants.JWT_CLIENT_ID_KEY);
        return clientId;
    }

    /**
     * 获取角色id集合
     *
     * @return
     */
    public static List<String> getRoleIds() {
        List<String> authorities = getJwtPayload().get(AuthConstants.JWT_AUTHORITIES_KEY, List.class);
        return authorities;
    }

}