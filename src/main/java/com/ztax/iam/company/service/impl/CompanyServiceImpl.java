package com.ztax.iam.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztax.common.utils.UuidUtil;
import com.ztax.iam.company.entity.Company;
import com.ztax.iam.company.mapper.CompanyMapper;
import com.ztax.iam.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2022-03-15
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public void addOne(Company paramCompany) {

        paramCompany.setCompanyId(UuidUtil.get32Uuid());

        companyMapper.insert(paramCompany);
    }

    /**
     * 通过id删除公司
     * 逻辑删除
     * @param companyId
     * @return
     */
    @Override
    public boolean deleteByIdWithFill(String companyId) {
        Company paramCompany = new Company();
        paramCompany.setCompanyId(companyId);
        int i = companyMapper.deleteByIdWithFill(paramCompany);
        return i == 1;
    }
}

