package com.ztax.iam.module.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ztax.iam.module.entity.Module;
import com.ztax.iam.module.entity.RouterVO;

import java.util.List;

/**
 * <p>
 * 菜单模块
 * </p>
 *
 * @since 2022-03-14
 */
public interface ModuleService extends IService<Module> {

    boolean deleteByIdWithFill(String moduleId);

    List<Module> list(QueryWrapper<Module> moduleQueryWrapper);

    List<Module> list(QueryWrapper<Module> moduleQueryWrapper, boolean isTree, boolean withMeta);

    List<Module> loadModuleEntityListByUserId(String userId, boolean isTree, boolean withMeta);

    List<RouterVO> loadRouterByUserId(String userId, boolean isTree);

    void checkInfoAvailable(Module baseQuery);

    boolean hasChild(String moduleId);

}
