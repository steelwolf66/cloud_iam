package com.ztax.iam.company.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztax.iam.aspect.DelFill;
import com.ztax.iam.company.entity.Company;
import com.ztax.iam.user.entity.User;

/**
 * <p>
    *  Mapper 接口
 * </p>
**/
public interface CompanyMapper extends BaseMapper<Company> {

    //逻辑删除 字段填充功能（固定写法）
    @DelFill
    int deleteByIdWithFill(Company entity);
}
