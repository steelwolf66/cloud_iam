package com.ztax.iam.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztax.common.aspect.DelFill;
import com.ztax.iam.user.entity.User;

/**
 * <p>
    *  Mapper 接口
 * </p>
**/
public interface UserMapper extends BaseMapper<User> {
    //逻辑删除 字段填充功能（固定写法）
    @DelFill
    int deleteByIdWithFill(User entity);
}
