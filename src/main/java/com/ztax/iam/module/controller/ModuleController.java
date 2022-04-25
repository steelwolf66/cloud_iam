package com.ztax.iam.module.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ztax.common.exception.BizException;
import com.ztax.common.result.Result;
import com.ztax.common.utils.ObjectUtils;
import com.ztax.common.utils.UuidUtil;
import com.ztax.iam.module.entity.Module;
import com.ztax.iam.module.entity.RouterVO;
import com.ztax.iam.module.service.impl.ModuleServiceImpl;
import com.ztax.iam.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleServiceImpl moduleService;

    /**
     * 新增一个模块
     *
     * @param paramModule 参数实体
     * @return Result<Module>
     */
    @PostMapping("/one")
    @Transactional(rollbackFor = Exception.class)
    public Result<Module> addOne(@RequestBody Module paramModule) {
        paramModule.setModuleId(UuidUtil.get32Uuid());
        paramModule.setHidden(Boolean.FALSE);
        //参数校验
        moduleService.checkInfoAvailable(paramModule);

        moduleService.save(paramModule);

        return Result.success(paramModule);
    }

    /**
     * 查询模块详情
     *
     * @param moduleId 模块id
     * @return Result<Module> 模块实体
     */
    @GetMapping(("/one/{moduleId}"))
    public Result<Module> one(@PathVariable("moduleId") String moduleId) {
        Module byId = moduleService.getById(moduleId);
        return Result.success(byId);
    }

    /**
     * 删除一个模块
     *
     * @param moduleId 模块id
     */
    @DeleteMapping("/one/{moduleId}")
    @Transactional(rollbackFor = Exception.class)
    public Result<String> deleteOne(@PathVariable("moduleId") String moduleId) {
        //删除校验 ，需先删除下级模块
        if (moduleService.hasChild(moduleId)) {
            throw new BizException("当前模块存在子模块，请先删除下级模块");
        }
        moduleService.deleteByIdWithFill(moduleId);

        return Result.success(moduleId);
    }

    /**
     * 修改菜单
     *
     * @param paramModule 参数实体
     * @return Result
     */
    @PutMapping("/one")
    @Transactional(rollbackFor = Exception.class)
    public Result<Module> updateModule(@RequestBody Module paramModule) {
        if (ObjectUtils.isBlank(paramModule.getModuleId())) {
            throw new BizException("module id 不可为空");
        }
        moduleService.checkInfoAvailable(paramModule);
        moduleService.updateById(paramModule);
        return Result.success(paramModule);
    }

    /**
     * 查询模块树 for 前端
     * 通过当前用户id查询
     *
     * @return Result<List < Module>>
     */
    @GetMapping("/tree")
    public Result<List<Module>> moduleTree() {
        String userId = WebUtils.getUserId();
        List<Module> moduleList = moduleService.loadModuleEntityListByUserId(userId, true, true);
        return Result.success(moduleList);
    }

    /**
     * router for 前端
     * 通过当前用户id查询
     *
     * @return Result<List < Module>>
     */
    @GetMapping("/router")
    public Result<List<RouterVO>> routeTree() {
        String userId = WebUtils.getUserId();
        List<RouterVO> routerVOList = moduleService.loadRouterByUserId(userId, true);
        return Result.success(routerVOList);
    }

    @GetMapping("/test")
    public Result<List<Module>> test() {
        String userId = WebUtils.getUserId();
        List<Module> modulsByUserId = moduleService.getModulsByUserId(userId);
        return Result.success(modulsByUserId);
    }
}