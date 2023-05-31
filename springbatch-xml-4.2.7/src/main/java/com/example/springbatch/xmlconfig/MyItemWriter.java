package com.example.springbatch.xmlconfig;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

public class MyItemWriter implements ItemWriter<String> , InitializingBean {

    @Override
    public void write(List<? extends String> items) throws Exception {
        System.out.println(items.toString());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("writer~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
