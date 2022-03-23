package com.ztax.iam.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztax.common.exception.BizException;
import com.ztax.common.utils.ObjectUtils;
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

    @Override
    public boolean deleteByIdWithFill(String userId) {
        User paramUser = new User();
        paramUser.setUserId(userId);
        paramUser.setDelFlg(Boolean.TRUE);
        int i = mapper.deleteByIdWithFill(paramUser);
        return i == 1;
    }


    @Override
    public boolean checkUsernameAvailable(User paramUser) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        userQueryWrapper
                .ne(ObjectUtils.isNotBlank(paramUser.getUserId()), "user_id", paramUser.getUserId())
                .eq("username", paramUser.getUsername());

        Integer count = mapper.selectCount(userQueryWrapper);
        return count == 0;
    }

    @Override
    public void processBeforeWrite(User paramUser) {
        paramUser.setUsername(paramUser.getUsername().toLowerCase());

        //用户名不可为空
        if (ObjectUtils.isBlank(paramUser.getUsername())) {
            throw new BizException("用户名不可为空");
        }

        //校验用户名是否可用
        boolean usernameAvailable = this.checkUsernameAvailable(paramUser);

        if(!usernameAvailable){
            throw new BizException("用户名已存在");
        }
    }
}

