package com.ztax.iam.company.entity;

import lombok.Data;

@Data
public class CompanyVO extends Company {
    private Integer pageNo;
    private Integer pageSize;
}