package com.ztax.iam.assignment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztax.common.utils.ObjectUtils;
import com.ztax.iam.assignment.entity.UserModuleRel;
import com.ztax.iam.assignment.mapper.UserModuleRelMapper;
import com.ztax.iam.assignment.service.UserModuleRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2022-03-14
 */
@Service
public class UserModuleRelServiceImpl extends ServiceImpl<UserModuleRelMapper, UserModuleRel> implements UserModuleRelService {
    @Resource
    private UserModuleRelMapper mapper;

    @Override
    public List<String> loadModuleIdsByUserId(String userId) {
        QueryWrapper<UserModuleRel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<UserModuleRel> resultList = mapper.selectList(queryWrapper);
        return resultList.stream().map(UserModuleRel::getModuleId).collect(Collectors.toList());
    }

    @Override
    public void grant(List<UserModuleRel> grantList) {
        if(ObjectUtils.isBlank(grantList)){
            return;
        }
        //删除所有旧的授权
        this.deleteOldGrant(grantList.get(0).getUserlId());

        //重新授权
        this.saveBatch(grantList);
    }

    @Override
    public void deleteOldGrant(String userId) {
        QueryWrapper paramWrapper = new QueryWrapper();
        paramWrapper.eq("user_id",userId);
        this.remove(paramWrapper);
    }
}

