package com.ztax.iam.assignment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ztax.iam.assignment.entity.UserModuleRel;
import com.ztax.iam.assignment.mapper.UserModuleRelMapper;
import com.ztax.iam.assignment.service.UserModuleRelService;
import com.ztax.zframe.mybatisplus.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2022-03-14
 */
@Service
public class UserModuleRelServiceImpl implements UserModuleRelService {
    @Resource
    private UserModuleRelMapper mapper;

    @Override
    public List<String> loadModuleIdsByUserId(String userId) {
        QueryWrapper<UserModuleRel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<UserModuleRel> resultList = mapper.selectList(queryWrapper);
        return resultList.stream().map(UserModuleRel::getModuleId).collect(Collectors.toList());
    }
}

