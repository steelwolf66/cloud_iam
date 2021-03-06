package com.ztax.iam.module.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztax.common.exception.BizException;
import com.ztax.common.utils.ObjectUtils;
import com.ztax.common.utils.TreeUtil;
import com.ztax.iam.assignment.service.impl.UserModuleRelServiceImpl;
import com.ztax.iam.base.constant.AdminConstant;
import com.ztax.iam.module.entity.Meta;
import com.ztax.iam.module.entity.Module;
import com.ztax.iam.module.entity.RouterVO;
import com.ztax.iam.module.mapper.ModuleMapper;
import com.ztax.iam.module.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2022-03-14
 */
@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements ModuleService {
    @Autowired
    private ModuleMapper moduleMapper;
    @Autowired
    private UserModuleRelServiceImpl userModuleRelService;

    /**
     * 逻辑删除，自动填充公共字段
     *
     * @param moduleId
     * @return
     */
    @Override
    public boolean deleteByIdWithFill(String moduleId) {
        Module paramModule = new Module();
        paramModule.setModuleId(moduleId);
        int i = moduleMapper.deleteByIdWithFill(paramModule);
        return i == 1;
    }

    @Override
    public List<Module> list(QueryWrapper<Module> moduleQueryWrapper) {
        //查询模块列表
        return this.baseMapper.selectList(moduleQueryWrapper);
    }

    /**
     * 返回树状路由表
     *
     * @param moduleQueryWrapper
     * @return
     */
    @Override
    public List<Module> list(QueryWrapper<Module> moduleQueryWrapper, boolean isTree, boolean withMeta) {
        List<Module> resultList = this.list(moduleQueryWrapper);
        if (withMeta) {
            //封装静态meta信息（前端路由组件要求）
            resultList.parallelStream()
                    .forEach(item -> {
                        item.setMeta(new Meta(
                                item.getModuleName()
                                , item.getIcon()
                                , item.getHidden()
                                , false
                                , item.getModuleType()
                                , Arrays.asList("ADMIN")));
                    });
        }
        if (isTree) {
            resultList = TreeUtil.toTree(resultList, Module::getModuleId, Module::getParentId, Module::setChildren, true);
        }
        return resultList;
    }

    /**
     * 同级模块下，模块名和排序需唯一
     *
     * @param baseQuery
     */
    @Override
    public void checkInfoAvailable(Module baseQuery) {
        //sort
        QueryWrapper<Module> moduleQueryWrapper = new QueryWrapper<>();
        moduleQueryWrapper.ne("module_id", baseQuery.getModuleId())
                .eq("sort", baseQuery.getSort())
                .eq("parent_id", baseQuery.getParentId())
        ;
        Integer count = this.baseMapper.selectCount(moduleQueryWrapper);
        if (count > 0) {
            throw new BizException("同级模块下，排序需唯一");
        }
        //module_name
        QueryWrapper<Module> moduleNameWrapper = new QueryWrapper<>();
        moduleNameWrapper.ne("module_id", baseQuery.getModuleId())
                .eq("module_name", baseQuery.getSort())
                .eq("parent_id", baseQuery.getParentId())
        ;
        Integer size = this.baseMapper.selectCount(moduleNameWrapper);
        if (size > 0) {
            throw new BizException("同级模块下，模块名称需唯一");
        }
    }

    /**
     * 查询改模块是否有子模块
     *
     * @param moduleId 模块id
     * @return 是否存在
     */
    @Override
    public boolean hasChild(String moduleId) {
        QueryWrapper<Module> moduleQueryWrapper = new QueryWrapper<>();
        moduleQueryWrapper.eq("parent_id", moduleId);
        List<Module> modules = this.baseMapper.selectList(moduleQueryWrapper);
        return ObjectUtils.isNotBlank(modules);
    }

    @Override
    public List<Module> getModulsByUserId(String userId) {
        List<Module> modules = moduleMapper.selectModuleListByUserId(userId);
        return modules;
    }


    /**
     * 加载用户关联的菜单实体
     *
     * @param userId 用户id
     * @param isTree 是否是树
     * @return 菜单实体集合
     */
    @Override
    public List<Module> loadModuleEntityListByUserId(String userId, boolean isTree, boolean withMeta) {
        //todo 一个SQL来完成,加载用户关联菜单实体
        QueryWrapper<Module> moduleQueryWrapper = this.buildQueryWrapperByUserId(userId);
        //通过模块id查询实体
        List<Module> treeModules = this.list(moduleQueryWrapper, isTree, withMeta);
        return treeModules;
    }

    public QueryWrapper<Module> buildQueryWrapperByUserId(String userId) {
        QueryWrapper<Module> moduleQueryWrapper = new QueryWrapper<>();
        //非admin ,查询关联菜单
        if (!AdminConstant.USER_ID_ADMIN.equalsIgnoreCase(userId)) {
            List<String> moduleIdsByUserId = userModuleRelService.loadModuleIdsByUserId(userId);
            if (ObjectUtils.isBlank(moduleIdsByUserId)) {
                throw new BizException("该用户未授权");
            }
            moduleQueryWrapper
                    .in(ObjectUtils.isNotBlank(moduleIdsByUserId), "module_id", moduleIdsByUserId);
        }
        return moduleQueryWrapper;
    }

    @Override
    public List<RouterVO> loadRouterByUserId(String userId, boolean isTree) {
        List<Module> moduleList = this.loadModuleEntityListByUserId(userId, false, true);
        List<RouterVO> routerVOList = new ArrayList<>();
        moduleList.parallelStream().forEach(item -> {
            RouterVO routerVO = new RouterVO();
            routerVO.setId(item.getModuleId());
            routerVO.setParentId(item.getParentId());
            routerVO.setName(item.getModuleName());
            routerVO.setComponent(item.getComponent());
            routerVO.setPath(item.getPath());
            routerVO.setMeta(item.getMeta());
            routerVOList.add(routerVO);
        });
        List<RouterVO> routerVOListResult = new ArrayList<>();

        //是否处理成树
        if (isTree) {
            routerVOListResult = TreeUtil.toTree(routerVOList, RouterVO::getId, RouterVO::getParentId, RouterVO::setChildren, true);
            return routerVOListResult;
        }
        return routerVOList;
    }


}

