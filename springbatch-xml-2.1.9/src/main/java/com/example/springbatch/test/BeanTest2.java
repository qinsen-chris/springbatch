package com.example.springbatch.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanTest2 {
    @Bean
    String beanName() {
        return "BEAN2";
    }
}
