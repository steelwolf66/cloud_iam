package com.ztax.iam.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztax.iam.user.entity.User;
import com.ztax.iam.user.mapper.UserMapper;
import com.ztax.iam.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 * user服务实现类
 * </p>
 *
 * @since 2022-03-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public Optional<User> loadUserByUsernameFromDB(String username) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", username);
        User user = mapper.selectOne(userQueryWrapper);

        return Optional.ofNullable(user);
    }
}

