package com.ztax.iam.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztax.common.aspect.DelFill;
import com.ztax.iam.module.entity.Module;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 **/
@Mapper
public interface ModuleMapper extends BaseMapper<Module> {
    //逻辑删除 字段填充功能（固定写法）
    @DelFill
    int deleteByIdWithFill(Module entity);

    List<Module> selectModuleListByUserId(String userId);
}
