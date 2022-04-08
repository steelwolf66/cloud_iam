package com.ztax.iam.module.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztax.common.result.Result;
import com.ztax.common.utils.UuidUtil;
import com.ztax.iam.module.entity.Module;
import com.ztax.iam.module.entity.ModuleVO;
import com.ztax.iam.module.service.impl.ModuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleServiceImpl moduleService;

    /**
     * 新增一个菜单
     *
     * @param paramModule
     * @return
     */
    @PostMapping("/one")
    @Transactional(rollbackFor = Exception.class)
    public Result addOne(@RequestBody Module paramModule) {
        paramModule.setModuleId(UuidUtil.get32Uuid());
        moduleService.save(paramModule);

        return Result.success(paramModule);
    }

    /**
     * 删除一个菜单
     *
     * @param moduleId
     */
    @DeleteMapping("/one/{moduleId}")
    @Transactional(rollbackFor = Exception.class)
    public Result deleteOne(@PathVariable("moduleId") String moduleId) {

        moduleService.deleteByIdWithFill(moduleId);

        return Result.success(moduleId);
    }

    /**
     * 修改菜单
     *
     * @param paramModule
     * @return
     */
    @PutMapping("/one")
    @Transactional(rollbackFor = Exception.class)
    public Result updateModule(@RequestBody Module paramModule) {
        moduleService.updateById(paramModule);
        return Result.success(paramModule);
    }

    /**
     * 菜单分页查询
     *
     * @param paramModule
     * @return
     */
    @PostMapping("/page")
    public Page<Module> page(@RequestBody ModuleVO paramModule) {
        Page<Module> objectPage = new Page<Module>((paramModule.getPageNo() - 1) * paramModule.getPageSize() + 1, paramModule.getPageSize());
        //配置查询条件
        QueryWrapper<Module> moduleQueryWrapper = new QueryWrapper<>();

        Page<Module> page = moduleService.page(objectPage, moduleQueryWrapper);

        return page;
    }
}