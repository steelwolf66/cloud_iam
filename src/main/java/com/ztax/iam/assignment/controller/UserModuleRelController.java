package com.ztax.iam.assignment.controller;


import com.ztax.common.result.Result;
import com.ztax.iam.assignment.entity.UserModuleRel;
import com.ztax.iam.assignment.service.impl.UserModuleRelServiceImpl;
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
     * 用户关联 公司、菜单
     *
     * @param paramList
     */
    @PostMapping("/grant")
    public void grant(@RequestBody List<UserModuleRel> paramList) {

        userModuleRelService.grant(paramList);
    }

    /**
     * 当前用户绑定菜单id
     *
     * @return
     */
    @GetMapping("/me/modules/list")
    public Result concurrentModules() {
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
    @GetMapping("/modules/{userId}")
    public Result grangByUserId(@PathVariable("userId") String userId) {
        List<String> moduleIdsByUserId = userModuleRelService.loadModuleIdsByUserId(userId);
        return Result.success(moduleIdsByUserId);
    }

}