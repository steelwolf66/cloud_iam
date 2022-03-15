package com.ztax.iam.user.service;

import com.ztax.iam.user.entity.User;
import com.ztax.zframe.mybatisplus.IBaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
    *  服务类
    * </p>
 *
 * @since 2022-03-14
 */

public interface UserService  {
    Optional<User> loadUserByUsernameFromDB(String username);
}
