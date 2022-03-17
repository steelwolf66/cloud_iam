package com.ztax.iam.assignment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztax.iam.assignment.entity.UserModuleRel;

import java.util.List;
/**
 * <p>
    *  服务类
    * </p>
 *
 * @since 2022-03-14
 */

public interface UserModuleRelService extends IService<UserModuleRel> {
    List<String> loadModuleIdsByUserId(String userId);

    void grant(List<UserModuleRel> grantList);

    void deleteOldGrant(String userId);
}
