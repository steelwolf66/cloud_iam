package com.ztax.iam.assignment.service;

import com.ztax.iam.assignment.entity.UserModuleRel;
import com.ztax.iam.module.entity.Module;
import com.ztax.zframe.mybatisplus.IBaseService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
    *  服务类
    * </p>
 *
 * @since 2022-03-14
 */

public interface UserModuleRelService  {
    List<String> loadModuleIdsByUserId(String userId);
}
