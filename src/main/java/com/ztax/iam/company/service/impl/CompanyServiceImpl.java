package com.ztax.iam.company.service.impl;

import com.ztax.iam.company.entity.Company;
import com.ztax.iam.company.mapper.CompanyMapper;
import com.ztax.iam.company.service.CompanyService;
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
public class CompanyServiceImpl extends BaseService<Company> implements CompanyService {
    @Resource
    private CompanyMapper mapper;

  public  void save(Company t){
        mapper.insertSelective(t);
    }

  public  int update(Company t){
        return mapper.updateByPrimaryKeySelective(t);
    }

  public  int delete(Company t){
         t.setDelType("1");
         return mapper.updateByPrimaryKey(t);
    }

  public  List<Company> queryListByBean(Company t){
        return mapper.selectListByBean(t);
    }


}
