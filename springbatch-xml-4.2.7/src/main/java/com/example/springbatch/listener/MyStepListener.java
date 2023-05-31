package com.example.springbatch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

import java.util.Map;

public class MyStepListener implements StepExecutionListener {

    public Map<String, JobParameter> parameterMap;
    
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("MyStepListener beforeStep " +stepExecution.getStepName());
        parameterMap = stepExecution.getJobParameters().getParameters();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("MyStepListener afterStep " +stepExecution.getStepName());
        return null;
    }
}
