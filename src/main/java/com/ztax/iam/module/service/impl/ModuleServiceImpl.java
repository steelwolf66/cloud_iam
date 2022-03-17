package com.ztax.iam.module.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztax.iam.module.entity.Module;
import com.ztax.iam.module.mapper.ModuleMapper;
import com.ztax.iam.module.service.ModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2022-03-14
 */
@Service
public class ModuleServiceImpl implements ModuleService {
    @Resource
    private ModuleMapper mapper;

    @Override
    public void addModule(Module paramModule) {
        mapper.insert(paramModule);
    }

    @Override
    public int updateModule(Module paramModule) {
        mapper.updateById(paramModule);
        return 0;
    }

    @Override
    public int deleteModule(Module paramModule) {
        paramModule.setDelType("1");
        mapper.updateById(paramModule);
        return 0;
    }

    @Override
    public Page<Module> pageModule(Module paramModule) {
        Page paramPage = new Page();
        paramPage.setCurrent(1L);
        paramPage.setSize(10L);
        QueryWrapper<Module> queryWrapper = new QueryWrapper<>();

        Page<Module> page = mapper.selectPage(paramPage, queryWrapper);

        return page;
    }

    @Override
    public List<Module> listModule(Module paramModule) {
        QueryWrapper<Module> queryWrapper = new QueryWrapper<>();

        return mapper.selectList(queryWrapper);
    }
}

