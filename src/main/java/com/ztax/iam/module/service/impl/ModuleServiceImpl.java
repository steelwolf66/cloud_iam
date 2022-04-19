package com.ztax.iam.module.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztax.common.exception.BizException;
import com.ztax.common.utils.ObjectUtils;
import com.ztax.common.utils.TreeUtil;
import com.ztax.iam.module.entity.Meta;
import com.ztax.iam.module.entity.Module;
import com.ztax.iam.module.mapper.ModuleMapper;
import com.ztax.iam.module.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Module> list(Module baseQuery) {
        //查询模块列表
        QueryWrapper<Module> moduleQueryWrapper = new QueryWrapper<>();
        //todo 配置查询条件
        return this.baseMapper.selectList(moduleQueryWrapper);
    }

    /**
     * 返回树状路由表
     *
     * @param baseQuery
     * @return
     */
    @Override
    public List<Module> listTree(Module baseQuery) {
        List<Module> resultList = this.list(baseQuery);
        //封装静态meta信息（前端路由组件要求）
        resultList.parallelStream().forEach(item -> {
            item.setMeta(new Meta(item.getModuleName(), item.getHidden(), false, Arrays.asList("ADMIN")));
        });
        List<Module> modules = TreeUtil.toTree(resultList, Module::getModuleId, Module::getParentId, Module::setChildren, true);
        return modules;
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

}

