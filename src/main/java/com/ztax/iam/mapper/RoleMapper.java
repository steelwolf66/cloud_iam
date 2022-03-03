package com.ztax.iam.mapper;

import com.ztax.iam.entity.SysUserRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("roleMapper")
public interface RoleMapper {

    @Select("SELECT user_id ,role_id " +
            "FROM sys_user_role " +
            "WHERE user_id=#{uid}")
    public List<SysUserRole> findByUid(Long uid);

}
