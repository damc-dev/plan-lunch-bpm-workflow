package com.dmcelligott;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by David on 12/22/2016.
 */
public class ActivitiConfig {

    @Bean
    public ProcessEngine processEngine(StandaloneInMemProcessEngineConfiguration standaloneInMemProcessEngineConfiguration, ApplicationContext applicationContext) throws Exception {
        ProcessEngineFactoryBean pe = new ProcessEngineFactoryBean();
        pe.setProcessEngineConfiguration(standaloneInMemProcessEngineConfiguration);
        pe.setApplicationContext(applicationContext);

        return pe.getObject();
    }

    @Bean
    public StandaloneInMemProcessEngineConfiguration standaloneInMemProcessEngineConfiguration(){
        StandaloneInMemProcessEngineConfiguration engine = new StandaloneInMemProcessEngineConfiguration();
        engine.setMailServerHost("smtp.gmail.com");
        engine.setMailServerPort(587);
        engine.setMailServerUseTLS(true);
        engine.setMailServerUsername("damc.dev@gmail.com");
        engine.setMailServerPassword("PointD3xter");
        engine.setMailServerDefaultFrom("damc.dev@gmail.com");
        return engine;
    }

    @Bean
    public RuntimeService getRuntimeService(ProcessEngine processEngine) {
        return processEngine.getRuntimeService();
    }
}
