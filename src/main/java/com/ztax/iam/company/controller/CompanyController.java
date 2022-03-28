package com.ztax.iam.company.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztax.common.result.Result;
import com.ztax.iam.company.entity.Company;
import com.ztax.iam.company.entity.CompanyVO;
import com.ztax.iam.company.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyServiceImpl companyService;

    /**
     * 新增公司
     *
     * @param company
     * @return
     */
    @PostMapping("/one")
    @Transactional(rollbackFor = Exception.class)
    public Result addOne(@RequestBody Company company) {

        companyService.addOne(company);

        return Result.success(company);
    }

    /**
     * 删除 by id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/one/{id}")
    @Transactional(rollbackFor = Exception.class)
    public Result deleteOne(@PathVariable("id") String id) {
        companyService.removeById(id);
        return Result.success(id);
    }

    /**
     * 修改
     *
     * @param company
     * @return
     */
    @PutMapping("/one")
    public Result updateOne(@RequestBody Company company) {

        companyService.updateById(company);

        return Result.success(company);
    }

    /**
     * 分页查询
     *
     * @param paramCompany
     * @return
     */
    @PostMapping("/page")
    public Result page(@RequestBody CompanyVO paramCompany) {

        Page paramPage = new Page((paramCompany.getPageNo() - 1) * paramCompany.getPageSize() + 1, paramCompany.getPageSize());

        //todo 拼接查询条件,
        QueryWrapper<Company> companyQueryWrapper = new QueryWrapper<>();

        Page resultPage = companyService.page(paramPage, companyQueryWrapper);
        return Result.success(resultPage);
    }
}