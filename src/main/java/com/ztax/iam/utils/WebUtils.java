package com.ztax.iam.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ztax.common.result.ResultCode;
import com.ztax.iam.auth.constants.AuthConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class WebUtils extends org.springframework.web.util.WebUtils {


    public static HttpServletRequest getHttpServletRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public static JSONObject getJwtPayload() {
        String jwtPayload = getHttpServletRequest().getHeader(AuthConstants.JWT_PAYLOAD_KEY);
        JSONObject jsonObject = JSONUtil.parseObj(jwtPayload);
        return jsonObject;
    }

    public static String getUserId() {
        String id = getJwtPayload().getStr(AuthConstants.JWT_USER_ID_KEY);
        return id;
    }

    public static String getClientId() {
        String clientId = getJwtPayload().getStr(AuthConstants.JWT_CLIENT_ID_KEY);
        return clientId;
    }

    public static List<Long> getRoleIds() {
        List<String> list = getJwtPayload().get(AuthConstants.JWT_AUTHORITIES_KEY, List.class);
        List<Long> authorities = list.stream().map(Long::valueOf).collect(Collectors.toList());
        return authorities;
    }

    public static ServerHttpResponse getServerHttpResponse(ResultCode resultCode) {

        return null;
    }

}