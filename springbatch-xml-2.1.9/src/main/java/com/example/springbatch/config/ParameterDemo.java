//package com.example.springbatch.config;
//
//import com.example.springbatch.listener.MyStepListener;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameter;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.StepContribution;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.scope.context.ChunkContext;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Map;
//
////@Configuration
////@EnableBatchProcessing
//public class ParameterDemo {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    public Map<String, JobParameter> parameterMap;
//
//    @Bean
//    public Job parameterDemoJob(){
//        return jobBuilderFactory.get("parameterDemoJob").start(parameterStep())
//                .build();
//    }
//
//    private Step parameterStep() {
//        MyStepListener myStepListener = new MyStepListener();
//
//        return stepBuilderFactory.get("parameterStep")
//                .listener(myStepListener)
//                .tasklet(new Tasklet() {
//                    @Override
//                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                        parameterMap = myStepListener.parameterMap;
//                        System.out.println("hello ParameterDemo parameterStep");
//                        System.out.println(parameterMap.isEmpty()?"ParameterDemo is empty":parameterMap.get("info"));
//                        return RepeatStatus.FINISHED;
//                    }
//        }).build();
//    }
//}
