package com.ztax.iam.module.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztax.iam.module.entity.Module;

import java.util.List;

/**
 * <p>
 * 菜单模块
 * </p>
 *
 * @since 2022-03-14
 */
public interface ModuleService  extends IService<Module> {

    boolean deleteByIdWithFill(String moduleId);

    List<Module> list(Module baseQuery);

    List<Module> listTree(Module baseQuery);

    void checkInfoAvailable(Module baseQuery);

    boolean hasChild(String moduleId);

}
