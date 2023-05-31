package com.example.springbatch.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
public class BeanTest {

//    @Primary
//    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    String beanName() {
        return "BEAN1";
    }
}
