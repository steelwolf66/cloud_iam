package com.ztax.iam.module.service.impl;

import com.ztax.iam.module.entity.Module;
import com.ztax.iam.module.mapper.ModuleMapper;
import com.ztax.iam.module.service.ModuleService;
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
public class ModuleServiceImpl extends BaseService<Module> implements ModuleService {
    @Resource
    private ModuleMapper mapper;

  public  void save(Module t){
        mapper.insertSelective(t);
    }

  public  int update(Module t){
        return mapper.updateByPrimaryKeySelective(t);
    }

  public  int delete(Module t){
         t.setDelType("1");
         return mapper.updateByPrimaryKey(t);
    }

  public  List<Module> queryListByBean(Module t){
        return mapper.selectListByBean(t);
    }


}

