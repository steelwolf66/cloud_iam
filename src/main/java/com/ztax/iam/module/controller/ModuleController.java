package com.ztax.iam.module.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztax.common.result.Result;
import com.ztax.common.utils.UuidUtil;
import com.ztax.iam.module.entity.Module;
import com.ztax.iam.module.service.impl.ModuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleServiceImpl moduleService;

    /**
     * 新增一个菜单
     * @param paramModule
     * @return
     */
    @PostMapping("/one")
    public Result addOne(@RequestBody Module paramModule) {
        paramModule.setModuleId(UuidUtil.get32Uuid());
        moduleService.save(paramModule);

        return Result.success(paramModule);
    }

    /**
     * 删除一个菜单
     * @param moduleId
     */
    @DeleteMapping("/one/{moduleId}")
    public void deleteOne(@PathVariable("moduleId") String moduleId) {
        Module paramModule = new Module();
        paramModule.setModuleId(moduleId);
        moduleService.removeById(paramModule);
    }

    /**
     * 修改菜单
     * @param paramModule
     * @return
     */
    @PutMapping("/one")
    public Result updateModule(@RequestBody Module paramModule) {
        moduleService.updateById(paramModule);
        return Result.success(paramModule);
    }

    /**
     * 菜单分页查询
     * @param paramModule
     * @return
     */
    @PostMapping("/page")
    public Page<Module> page(@RequestBody Module paramModule) {
        Page<Module> objectPage = new Page<Module>(1, 10);
        //todo 配置查询条件
        QueryWrapper<Module> moduleQueryWrapper = new QueryWrapper<>();

        Page<Module> page = moduleService.page(objectPage, moduleQueryWrapper);

        return page;
    }
}