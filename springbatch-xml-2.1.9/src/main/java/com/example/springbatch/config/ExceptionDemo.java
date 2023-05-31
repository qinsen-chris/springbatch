/*
package com.example.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableBatchProcessing
public class ExceptionDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job exceptionDemoJob(){
        return jobBuilderFactory.get("exceptionDemoJob")
                .start(exceptionStep())
                .build();
    }

    private Step exceptionStep() {
        return stepBuilderFactory.get("exceptionStep")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        Map<String,Object> stepExceptionContext = chunkContext.getStepContext().getStepExecutionContext();
                        if(stepExceptionContext.containsKey("qingfeng")){
                            System.out.println("the second will be success!");
                            return RepeatStatus.FINISHED;
                        }else{
                            System.out.println("the first will be fail!");
                            chunkContext.getStepContext().getStepExecution().getExecutionContext().put("qingfeng","springbatch");
                            throw new RuntimeException("error......");
                        }
                    }
                }).build();
    }
}
*/
