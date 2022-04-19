package com.ztax.iam.module.entity;

import lombok.Data;

import java.util.List;

@Data
public class ModuleVO extends Module {
private List<Module> children;
}
