package com.ztax.iam.module.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztax.iam.module.entity.Module;

import java.util.List;

/**
 * <p>
 * 菜单模块
 * </p>
 *
 * @since 2022-03-14
 */
public interface ModuleService {
    void addModule(Module paramModule);

    int updateModule(Module paramModule);

    int deleteModule(Module paramModule);

    Page<Module> pageModule(Module paramModule);

    List<Module> listModule(Module paramModule);
}
