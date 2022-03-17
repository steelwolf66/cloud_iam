package com.ztax.iam.auth.filter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ztax.iam.user.entity.SecurityUser;
import com.ztax.iam.user.entity.User;
import com.ztax.iam.user.entity.UserDTO;
import com.ztax.iam.user.service.impl.UserServiceImpl;
import com.ztax.iam.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private UserServiceImpl userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 如果已经通过认证
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            chain.doFilter(request, response);
            return;
        }
        String userId = WebUtils.getUserId();
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        User userByUserId = userService.getOne(queryWrapper);
        //获取权限
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userByUserId, userDTO);

        SecurityUser currentUser = new SecurityUser(userDTO);


        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(currentUser, currentUser.getPassword(), currentUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        chain.doFilter(request, response);
    }

}
