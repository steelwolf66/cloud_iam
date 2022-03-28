package com.ztax.iam.module.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztax.iam.module.entity.Module;
import com.ztax.iam.module.mapper.ModuleMapper;
import com.ztax.iam.module.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

