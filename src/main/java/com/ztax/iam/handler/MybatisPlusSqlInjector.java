package com.ztax.iam.handler;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;

import java.util.List;

/**
 * SQL注入配置器
 * 解决删除公共字段填充问题
 */
public class MybatisPlusSqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        final List<AbstractMethod> methods = super.getMethodList(mapperClass);

        methods.add(new LogicDeleteByIdWithFill());

        return methods;
    }
}