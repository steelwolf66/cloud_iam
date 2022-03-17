package com.ztax.iam.module.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztax.iam.module.entity.Module;
import com.ztax.iam.module.service.impl.ModuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

;

@RestController
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    private ModuleServiceImpl moduleService;

    @PostMapping("/one")
    public void addOne(@RequestBody Module paramModule) {
        moduleService.addModule(paramModule);
    }

    @DeleteMapping("/one/{moduleId}")
    public void deleteOne(@PathVariable("moduleId") String moduleId) {
        Module paramModule = new Module();
        paramModule.setModuleId(moduleId);
        moduleService.deleteModule(paramModule);
    }

    @PutMapping("/one")
    public void deleteOne(@RequestBody Module paramModule) {
        moduleService.updateModule(paramModule);
    }

    @PostMapping("/page")
    public Page<Module> page(@RequestBody Module paramModule) {
        return moduleService.pageModule(paramModule);
    }
}