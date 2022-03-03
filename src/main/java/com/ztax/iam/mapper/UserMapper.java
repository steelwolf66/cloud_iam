package com.ztax.iam.mapper;

import com.ztax.iam.entity.SysUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository("userMapper")
public interface UserMapper{

    @Select("select * from sys_user where username=#{username}")
    public SysUser findByUsername(String username);
}
