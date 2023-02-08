package com.example.yourproject.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).// Swagger分组
                // enable(false) //enable是否启动Swagger,如果为false,则Sagger不能在浏览器中访问
                // RequestHandlerSelectors 配置要扫描接口的方式
                // basePackage:指定要扫描的包
                // any():扫描全部
                // none():不扫描
                // withClassAnnotation:扫描类上的注解，参数是一个注解的反射对象
                // withMethodAnnotation:扫描方法上的注解
                        select().apis(RequestHandlerSelectors.basePackage("com.example.yourproject")).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("后台接口API")
                .description("")
                .termsOfServiceUrl("")
                .version("1.0.0").build();
    }
}
