package com.example.springbatch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class BatchController {

    @Autowired
    private JobLauncher jobLauncher;

    @Qualifier("sampleJob")
    @Autowired
    private Job job;

    @RequestMapping("/batch/{batchDate}")
    public String batch(@PathVariable("batchDate") String batchDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
        JobParameters jobParameters = new JobParametersBuilder()
                .addDate("startDate",format.parse(batchDate))
                .toJobParameters();

            jobLauncher.run(job,jobParameters);
        } catch (ParseException e) {
            return "传入批次日期参数不合要求";
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }

        return "success";
    }

    @RequestMapping("/test1")
    public String test1(){
        System.out.println("test1");
        return "test1";
    }

    @RequestMapping("/test2")
    public String test2(){
        System.out.println("test2");
        return "test2";
    }

}
