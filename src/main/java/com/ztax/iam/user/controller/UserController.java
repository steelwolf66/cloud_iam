package com.ztax.iam.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.ztax.common.result.Result;
import com.ztax.iam.user.constant.UserConstant;
import com.ztax.iam.user.entity.User;
import com.ztax.iam.user.service.impl.UserServiceImpl;
import com.ztax.iam.utils.WebUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

;
;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;

    private final UserServiceImpl userService;

    /**
     * 新建用户
     *
     * @param paramUser
     * @return
     */
    @PostMapping("/one")
    public Result addOne(@RequestBody User paramUser) {
        //todo 默认密码123456
        passwordEncoder.encode(UserConstant.DEFAULT_USER_PASSWORD);
//        userService.save(paramUser);
        //todo 设置用户关联权限

        return Result.success();
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/one/{userId}")
    @Transactional(rollbackFor = Exception.class)
    public Result deleteOne(@PathVariable("userId") String userId) {
//        userService.deleteByPrimaryKey(userId);

        return Result.success();
    }

    /**
     * 修改用户
     *
     * @param paramUser
     * @return
     */
    @PostMapping
    public Result updateOne(@RequestBody User paramUser) {

        return Result.success();
    }

    /**
     * 获取当前登录人信息
     *
     * @return
     */
    @GetMapping("/me")
    public Result myInfo() {
        String userId = WebUtils.getUserId();
        //todo 从数据库中查询或从缓存中查询

        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userId);
        User userByUserId = userService.getOne(queryWrapper);
        //todo 查询权限信息

        return Result.success(userByUserId);
    }

    /**
     * 查询用户列表
     *
     * @param paramUser
     * @return
     */
    @PostMapping("/page")
    public Result userList(@RequestBody User paramUser) {
        Page paramPage = new Page(1, 10);
//        PageInfo<User> userPageInfo = userService.queryPageByBean(paramUser, paramPage);
        return Result.success();
    }
}