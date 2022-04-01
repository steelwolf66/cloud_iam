package com.ztax.iam.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztax.common.result.Result;
import com.ztax.common.utils.ObjectUtils;
import com.ztax.iam.user.constant.UserConstant;
import com.ztax.iam.user.entity.User;
import com.ztax.iam.user.entity.UserVO;
import com.ztax.iam.user.service.impl.UserServiceImpl;
import com.ztax.iam.utils.WebUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


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
    @Transactional(rollbackFor = Exception.class)
    public Result<User> addOne(@RequestBody User paramUser) {
        userService.processBeforeWrite(paramUser);

        //默认密码123456
        String pwd = passwordEncoder.encode(UserConstant.DEFAULT_USER_PASSWORD);
        paramUser.setPassword(pwd);
        userService.save(paramUser);
        //todo 设置用户关联权限

        return Result.success(paramUser);
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/one/{userId}")
    @Transactional(rollbackFor = Exception.class)
    public Result<String> deleteOne(@PathVariable("userId") String userId) {


        userService.deleteByIdWithFill(userId);

        return Result.success(userId);
    }

    /**
     * 修改用户
     *
     * @param paramUser
     * @return
     */
    @PutMapping("/one")
    public Result<User> updateOne(@RequestBody User paramUser) {

        //用户名不可修改
        paramUser.setUsername(null);

        userService.updateById(paramUser);
        return Result.success();
    }

    /**
     * 获取当前登录人信息
     *
     * @return
     */
    @GetMapping("/me")
    public Result<User> myInfo() {
        String userId = WebUtils.getUserId();
        //todo 从数据库中查询或从缓存中查询

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("user_id", userId);
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
    public Result<Page<User>> userList(@RequestBody UserVO paramUser) {
        Page<User> paramPage = new Page<User>((paramUser.getPageNo()-1) * paramUser.getPageSize() + 1, paramUser.getPageSize());
        //todo 设置查询属性
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like(ObjectUtils.isNotBlank(paramUser.getUsername()),"username",paramUser.getUsername())
        .like(ObjectUtils.isNotBlank(paramUser.getNickname()),"nickname",paramUser.getNickname());
        Page<User> resultPage = userService.page(paramPage, userQueryWrapper);
        return Result.success(resultPage);
    }
}