package com.example.springbatch.config;

import org.springframework.batch.core.scope.BatchScopeSupport;
import org.springframework.batch.core.scope.JobScope;
import org.springframework.batch.core.scope.StepScope;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class A implements BeanFactoryPostProcessor, PriorityOrdered {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BatchScopeSupport stepScopeBean = beanFactory.getBean(StepScope.class);
        if(stepScopeBean != null){
            stepScopeBean.setAutoProxy(true);
        }
        BatchScopeSupport jobScopeBean = beanFactory.getBean(JobScope.class);
        if(jobScopeBean != null){
            jobScopeBean.setAutoProxy(true);
        }

        System.out.println("[BeanFactoryAware] update autoProxy to true");
    }
}
