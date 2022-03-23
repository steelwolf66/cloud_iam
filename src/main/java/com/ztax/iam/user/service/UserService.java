package com.ztax.iam.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztax.iam.user.entity.User;

import java.util.Optional;

/**
 * <p>
    *  服务类
    * </p>
 *
 * @since 2022-03-14
 */

public interface UserService  extends IService<User> {
    Optional<User> loadUserByUsernameFromDB(String username);

    boolean deleteByIdWithFill(String userId);

    boolean checkUsernameAvailable(User paramUser);

    void processBeforeWrite(User paramUser);
}
