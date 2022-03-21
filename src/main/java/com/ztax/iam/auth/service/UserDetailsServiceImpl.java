package com.ztax.iam.auth.service;

import com.ztax.common.utils.ObjectUtils;
import com.ztax.iam.assignment.service.impl.UserModuleRelServiceImpl;
import com.ztax.iam.user.entity.SecurityUser;
import com.ztax.iam.user.entity.User;
import com.ztax.iam.user.entity.UserDTO;
import com.ztax.iam.user.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 实现UserDetailsService
 * 在认证过程中加载自定义对象
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserModuleRelServiceImpl userModuleRelService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从数据库中查询用户信息及角色信息 并封装User对象
        Optional<User> userOptional = userService.loadUserByUsernameFromDB(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("用户不存在");
        }

        //获取权限
        User userByUsername = userOptional.get();
        String userId = userByUsername.getUserId();
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userByUsername, userDTO);

        //设置菜单(即权限)集合
        List<String> moduleIds = userModuleRelService.loadModuleIdsByUserId(userId);
        if (ObjectUtils.isNotBlank(moduleIds)) {
            userDTO.setModuleIds(moduleIds);
        }


        SecurityUser currentUser = new SecurityUser(userDTO);

        if (!currentUser.isEnabled()) {
            throw new DisabledException("该账户已被禁用!");
        } else if (!currentUser.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定!");
        } else if (!currentUser.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期!");
        }

        return currentUser;
    }
}
