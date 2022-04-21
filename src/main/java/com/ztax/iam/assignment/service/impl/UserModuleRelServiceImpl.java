package com.ztax.iam.assignment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztax.common.utils.ObjectUtils;
import com.ztax.common.utils.TreeUtil;
import com.ztax.iam.assignment.entity.UserModuleRel;
import com.ztax.iam.assignment.mapper.UserModuleRelMapper;
import com.ztax.iam.assignment.service.UserModuleRelService;
import com.ztax.iam.module.entity.Module;
import com.ztax.iam.module.service.impl.ModuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户授权实现类
 * </p>
 *
 * @since 2022-03-14
 */
@Service
public class UserModuleRelServiceImpl extends ServiceImpl<UserModuleRelMapper, UserModuleRel> implements UserModuleRelService {

    @Resource
    private UserModuleRelMapper mapper;

    @Autowired
    private ModuleServiceImpl moduleService;

    /**
     * 通过用户id加载所有授权（菜单id集合）
     *
     * @param userId 用户id
     * @return 所有授权
     */
    @Override
    public List<String> loadModuleIdsByUserId(String userId) {
        QueryWrapper<UserModuleRel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<UserModuleRel> resultList = mapper.selectList(queryWrapper);
        return resultList.stream().map(UserModuleRel::getModuleId).collect(Collectors.toList());
    }

    /**
     * 加载用户关联的菜单实体
     *
     * @param userId 用户id
     * @param isTree 是否是树
     * @return 菜单实体集合
     */
    @Override
    public List<Module> loadModuleListByUserId(String userId, boolean isTree) {
        //todo 一个SQL来完成,加载用户关联菜单实体
        //加载用户关联的所有模块id
        List<String> moduleIdsByUserId = this.loadModuleIdsByUserId(userId);
        if (ObjectUtils.isBlank(moduleIdsByUserId)) {
            return new ArrayList<>();
        }
        //通过模块id查询实体
        QueryWrapper<Module> moduleQueryWrapper = new QueryWrapper<>();
        moduleQueryWrapper.in(ObjectUtils.isNotBlank(moduleIdsByUserId), "module_id", moduleIdsByUserId);
        List<Module> treeModules = moduleService.list(moduleQueryWrapper);

        //将结果转化为树
        if (isTree) {
            treeModules = TreeUtil.toTree(treeModules, Module::getModuleId, Module::getParentId, Module::setChildren, true);
        }

        return treeModules;
    }

    /**
     * 用户授权
     *
     * @param grantList 授权列表
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void grant(List<UserModuleRel> grantList) {
        if (ObjectUtils.isBlank(grantList)) {
            return;
        }
        //删除所有旧的授权
        this.removeOldGrant(grantList.get(0).getUserId());

        //持久化新的授权
        this.saveBatch(grantList);
    }

    /**
     * 删除当前用户【历史授权】
     *
     * @param userId 用户id
     */
    @Override
    public void removeOldGrant(String userId) {
        QueryWrapper<UserModuleRel> paramWrapper = new QueryWrapper<UserModuleRel>();
        paramWrapper.eq("user_id", userId);
        this.remove(paramWrapper);
    }
}

