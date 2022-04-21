package com.ztax.iam.assignment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztax.iam.assignment.entity.UserModuleRel;
import com.ztax.iam.module.entity.Module;

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

    List<Module> loadModuleListByUserId(String userId,boolean isTree);

    void grant(List<UserModuleRel> grantList);

    void removeOldGrant(String userId);
}
