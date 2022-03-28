package com.ztax.iam.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztax.iam.aspect.DelFill;
import com.ztax.iam.module.entity.Module;
import com.ztax.iam.user.entity.User;

/**
 * <p>
    *  Mapper 接口
 * </p>
**/
public interface ModuleMapper extends BaseMapper<Module> {
    //逻辑删除 字段填充功能（固定写法）
    @DelFill
    int deleteByIdWithFill(Module entity);
}
