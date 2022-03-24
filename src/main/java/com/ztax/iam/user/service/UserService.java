package com.ztax.iam.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztax.iam.user.entity.User;

import java.util.Optional;

/**
 * <p>
    *  user服务类
    * </p>
 *
 * @since 2022-03-14
 */

public interface UserService  extends IService<User> {
    /**
     * 通过用户名从数据库加载用户信息
     * for security authentication
     * @param username
     * @return
     */
    Optional<User> loadUserByUsernameFromDB(String username);

    /**
     * 通过用户id删除用户，自适应填充删除相关字段
     * @param userId
     * @return
     */
    boolean deleteByIdWithFill(String userId);

    /**
     * 校验用户名是否可用
     * @param paramUser
     * @return
     */
    boolean checkUsernameAvailable(User paramUser);

    /**
     * 写操作之前的一些校验和处理
     * @param paramUser
     */
    void processBeforeWrite(User paramUser);
}
