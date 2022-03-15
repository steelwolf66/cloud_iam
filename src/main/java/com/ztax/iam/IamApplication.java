package com.ztax.iam;

import com.ztax.common.config.RsaKeyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.ztax.iam"
		,"com.ztax.common"})
@EnableDiscoveryClient
@MapperScan("com.ztax.iam")
@EnableConfigurationProperties(RsaKeyProperties.class)  //将配置类放入Spring容器中
public class IamApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamApplication.class, args);
	}
}
