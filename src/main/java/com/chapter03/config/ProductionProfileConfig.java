//package com.zrz.chapter03.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.jndi.JndiObjectFactoryBean;
//
//import javax.sql.DataSource;
//
//@Configuration
//@Profile("Production")
//public class ProductionProfileConfig {
//
//    @Bean
//    public DataSource dataSource(){
//        JndiObjectFactoryBean jndiObjectFactoryBean=new JndiObjectFactoryBean();
//        jndiObjectFactoryBean.setJndiName("jdbc/myDs");
//        jndiObjectFactoryBean.setResourceRef(true);
//        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
//        return (DataSource)jndiObjectFactoryBean.getObject();
//    }
//}
