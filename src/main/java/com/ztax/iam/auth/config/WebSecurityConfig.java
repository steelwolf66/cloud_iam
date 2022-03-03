package com.ztax.iam.auth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *配置免密请求等
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 登录失败处理handler，返回一段json
        http
                .authorizeRequests().requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
                .and()
                //获取公钥接口和登出接口免密
                .authorizeRequests().antMatchers("/getPublicKey", "/oauth/logout").permitAll()
                .anyRequest().authenticated()
                .and()
                //禁用csrf
                .csrf().disable();
    }

    /**
     * 如果不配置SpringBoot会自动配置一个AuthenticationManager,覆盖掉内存中的用户
     */
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 密码加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
