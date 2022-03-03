package com.ztax.iam.auth.service;

import com.ztax.common.utils.ObjectUtils;
import com.ztax.iam.entity.SysUser;
import com.ztax.iam.entity.SysUserRole;
import com.ztax.iam.entity.User;
import com.ztax.iam.entity.UserDTO;
import com.ztax.iam.mapper.RoleMapper;
import com.ztax.iam.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现UserDetailsService
 * 在认证过程中加载自定义对象
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //todo 从数据库中查询用户信息及角色信息 并封装User对象
        SysUser byUsername = new SysUser();
        try {
            byUsername = userMapper.findByUsername(username);
            List<SysUserRole> assignmentList = roleMapper.findByUid(byUsername.getId());
            if (ObjectUtils.isNotBlank(assignmentList)) {
                byUsername.setRoleIds(assignmentList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList()));
            }
        } catch (Exception e) {
            logger.error("get userinfo from db exception", e);
        }

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(byUsername, userDTO);
        User currentUser = new User(userDTO);

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
