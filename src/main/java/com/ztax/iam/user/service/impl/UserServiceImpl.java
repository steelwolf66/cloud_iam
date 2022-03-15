package com.ztax.iam.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ztax.common.utils.ObjectUtils;
import com.ztax.iam.user.entity.User;
import com.ztax.iam.user.mapper.UserMapper;
import com.ztax.iam.user.service.UserService;
import com.ztax.zframe.mybatisplus.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;

/**
 * <p>
 * user服务实现类
 * </p>
 *
 * @since 2022-03-14
 */
@Service
public class UserServiceImpl implements UserService {
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

