package com.ztax.iam.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.ztax.iam.handler.MybatisPlusSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

    /**
     * 公共字段自适应填充配置
     * @return
     */
    @Bean
    public MybatisPlusSqlInjector mybatisPlusSqlInjector(){
        return new MybatisPlusSqlInjector();
    }

}
