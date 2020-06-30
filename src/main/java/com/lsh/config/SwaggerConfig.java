package com.lsh.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
// http://localhost:1285/cms/swagger-ui.html 接口查看地址
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.lsh.web.Controller")) //指定扫描的包
                //.paths(PathSelectors.ant("/swagger/**")) //过滤路径
                .build();
    }
    private ApiInfo apiInfo(){
        Contact contact = new Contact("lshirs", "lshirs.cn", "lshirs@163.com");
        return new ApiInfo("电影API",
                "接口测试",
                "1.0",
                "lshirs.cn",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
