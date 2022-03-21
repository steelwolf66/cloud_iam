package com.ztax.iam.company.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztax.iam.company.entity.Company;

/**
 * <p>
    *  公司
    * </p>
 *
 * @since 2022-03-15
 */
public interface CompanyService extends IService<Company> {

    void addOne(Company paramCompany);


}
