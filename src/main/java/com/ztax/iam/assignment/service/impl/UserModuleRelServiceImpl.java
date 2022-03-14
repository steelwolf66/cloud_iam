package com.ztax.iam.assignment.service.impl;

import com.ztax.iam.assignment.entity.UserModuleRel;
import com.ztax.iam.assignment.mapper.UserModuleRelMapper;
import com.ztax.iam.assignment.service.UserModuleRelService;
import com.ztax.zframe.mybatisplus.BaseService;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;
/**
 * <p>
    *  服务实现类
    * </p>
 *
 * @since 2022-03-14
 */
@Service
public class UserModuleRelServiceImpl extends BaseService<UserModuleRel> implements UserModuleRelService {
    @Resource
    private UserModuleRelMapper mapper;

  public  void save(UserModuleRel t){
        mapper.insertSelective(t);
    }

  public  int update(UserModuleRel t){
        return mapper.updateByPrimaryKey(t);
    }

  public  int delete(UserModuleRel t){
         return mapper.deleteByBean(t);
    }

  public  List<UserModuleRel> queryListByBean(UserModuleRel t){
        return mapper.selectListByBean(t);
    }


}

