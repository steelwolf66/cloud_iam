package com.ztax.iam.assignment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztax.common.utils.ObjectUtils;
import com.ztax.iam.assignment.entity.UserModuleRel;
import com.ztax.iam.assignment.mapper.UserModuleRelMapper;
import com.ztax.iam.assignment.service.UserModuleRelService;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户授权实现类
 * </p>
 *
 * @since 2022-03-14
 */
@Service
public class UserModuleRelServiceImpl extends ServiceImpl<UserModuleRelMapper, UserModuleRel> implements UserModuleRelService {

    @Resource
    private UserModuleRelMapper mapper;

    /**
     * 通过用户id加载所有授权
     *
     * @param userId 用户id
     * @return 所有授权
     */
    @Override
    public List<String> loadModuleIdsByUserId(String userId) {
        QueryWrapper<UserModuleRel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<UserModuleRel> resultList = mapper.selectList(queryWrapper);
        return resultList.stream().map(UserModuleRel::getModuleId).collect(Collectors.toList());
    }

    /**
     * 用户授权
     *
     * @param grantList 授权列表
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void grant(List<UserModuleRel> grantList) {
        if (ObjectUtils.isBlank(grantList)) {
            return;
        }
        //删除所有旧的授权
        this.removeOldGrant(grantList.get(0).getUserlId());

        //持久化新的授权
        this.saveBatch(grantList);
    }

    /**
     * 删除当前用户【历史授权】
     *
     * @param userId 用户id
     */
    @Override
    public void removeOldGrant(String userId) {
        QueryWrapper<UserModuleRel> paramWrapper = new QueryWrapper<UserModuleRel>();
        paramWrapper.eq("user_id", userId);
        this.remove(paramWrapper);
    }
}

