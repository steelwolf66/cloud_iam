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
    /**
     * 通过moduleId删除
     * 逻辑删
     * @param moduleId
     * @return
     */
    boolean deleteByIdWithFill(String moduleId);

    /**
     * 通过queryWrapper查询
     * @param moduleQueryWrapper
     * @return
     */
    List<Module> list(QueryWrapper<Module> moduleQueryWrapper);

    /**
     * 通过queryWrapper查询
     * 是否要树，是否携带meta
     * @param moduleQueryWrapper 查询条件
     * @param isTree 是否为树
     * @param withMeta 是否携带meta
     * @return
     */
    List<Module> list(QueryWrapper<Module> moduleQueryWrapper, boolean isTree, boolean withMeta);

    /**
     * 通过用户id，加载模块实体
     * @param userId 用户id
     * @param isTree 是否是树
     * @param withMeta 是否携带meta
     * @return
     */
    List<Module> loadModuleEntityListByUserId(String userId, boolean isTree, boolean withMeta);

    /**
     * 通过用户id加载路由实体
     * @param userId 用户id
     * @param isTree 是否是树
     * @return
     */
    List<RouterVO> loadRouterByUserId(String userId, boolean isTree);

    /**
     * 校验模块信息可用性
     * @param baseQuery
     */
    void checkInfoAvailable(Module baseQuery);

    /**
     * 校验是否有子集
     * @param moduleId
     * @return
     */
    boolean hasChild(String moduleId);

    List<Module> getModulsByUserId(String userId);
}
