//package com.example.springbatch.xmlconfig;
//
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class JobConfig {
//
//    @Bean("sampleItemReader")
//    @StepScope
//    public MyItemReader sampleItemReader(){
//        List<String> list = new ArrayList<>();
//        list.add("5");
//        list.add("6");
//        list.add("7");
//        list.add("8");
//        return new MyItemReader(list);
//    }
//
//    @Bean("sampleItemWriter")
//    @StepScope
//    public MyItemWriter sampleItemWriter(){
//        return new MyItemWriter();
//    }
//}
