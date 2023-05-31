package com.example.springbatch.xmlconfig;

import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;

public class MyItemReader extends ListItemReader<String> implements InitializingBean {

    public MyItemReader(List<String> list) {
        super(list);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
    }

    @Override
    public String read() {
        return super.read();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("raader~~~~~~~~~~~~~~~~~~~~");
    }
}
