package com.ztax.iam.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusSqlInjector mybatisPlusSqlInjector(){
        return new MybatisPlusSqlInjector();
    }


}