package com.lsh.config;

import com.lsh.dialect.DictDialect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DialectConfig {
    @Bean
    @ConditionalOnMissingBean
    public DictDialect customDialect(){
        return new DictDialect("自定义字典方言类");
    }
}
