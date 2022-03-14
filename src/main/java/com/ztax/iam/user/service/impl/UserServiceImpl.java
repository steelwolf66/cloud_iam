package com.ztax.iam.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ztax.iam.user.entity.User;
import com.ztax.iam.user.mapper.UserMapper;
import com.ztax.iam.user.service.UserService;
import com.ztax.zframe.mybatisplus.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;

/**
 * <p>
 * user服务实现类
 * </p>
 *
 * @since 2022-03-14
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService {
    @Resource
    private UserMapper mapper;

    public void save(User t) {
        mapper.insertSelective(t);
    }

    public int update(User t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    public int delete(User t) {
        t.setDelType("1");
        return mapper.updateByPrimaryKey(t);
    }

    public List<User> queryListByBean(User t) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.ge("age",35);//年龄大于35
        userQueryWrapper.eq("username",t.getUsername());//username为查询条件
        userQueryWrapper.orderByAsc("userid");

        return mapper.selectListByBean(t);
    }


}

