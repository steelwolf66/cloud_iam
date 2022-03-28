package com.ztax.iam.module.entity;

import lombok.Data;

@Data
public class ModuleVO extends Module {
    private Integer pageNo;
    private Integer pageSize;
}
