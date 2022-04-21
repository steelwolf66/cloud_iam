package com.ztax.iam.assignment.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ztax.common.result.Result;
import com.ztax.common.utils.ObjectUtils;
import com.ztax.iam.assignment.entity.UserModuleRel;
import com.ztax.iam.assignment.service.impl.UserModuleRelServiceImpl;
import com.ztax.iam.module.entity.Module;
import com.ztax.iam.module.service.impl.ModuleServiceImpl;
import com.ztax.iam.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/assignment")
public class UserModuleRelController {

    @Autowired
    private UserModuleRelServiceImpl userModuleRelService;


    /**
     * 用户关联菜单
     *
     * @param paramList
     */
    @PostMapping("/grant")
    public Result grant(@RequestBody List<UserModuleRel> paramList) {

        userModuleRelService.grant(paramList);
        return Result.success();
    }

    /**
     * 当前用户绑定菜单id
     *
     * @return
     */
    @GetMapping("/me/modules/list")
    public Result<List<String>> concurrentModules() {
        String userId = WebUtils.getUserId();
        //目前是从数据库中获取数据，后续可优化为从缓存中获取以提加载速度
        List<String> moduleIdsByUserId = userModuleRelService.loadModuleIdsByUserId(userId);

        return Result.success(moduleIdsByUserId);
    }

    /**
     * 通过用户id查询用户关联菜单
     * todo 这里可以修改成完整返回关联的表数据
     *
     * @param userId
     * @return
     */
    @GetMapping("/modules/id/{userId}")
    public Result<List<String>> loadModuleIdsByUserId(@PathVariable("userId") String userId) {
        List<String> moduleIdsByUserId = userModuleRelService.loadModuleIdsByUserId(userId);
        return Result.success(moduleIdsByUserId);
    }

    /**
     * 通过用户id加载用户菜单实体
     *
     * @param userId
     * @return
     */
    @GetMapping("/modules/entity/{userId}")
    public Result<List<Module>> loadModuleListByUserId(@PathVariable("userId") String userId) {
        return Result.success(userModuleRelService.loadModuleListByUserId(userId, false));
    }
}