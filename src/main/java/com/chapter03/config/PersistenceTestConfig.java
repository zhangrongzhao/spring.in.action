//package com.zrz.chapter03.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.jndi.JndiObjectFactoryBean;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class PersistenceTestConfig {
//
//    @Bean(destroyMethod = "")
//    @Profile("dev")
//    public DataSource h2DataSource(){
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("classpath:schema.sql")
//                .addScript("classpath:test-data.sql")
//                .build();
//    }
//
//    @Bean
//    @Profile("production")
//    public DataSource jndiDataSource(){
//        JndiObjectFactoryBean jndiObjectFactoryBean=new JndiObjectFactoryBean();
//        jndiObjectFactoryBean.setJndiName("jdbc/myDs");
//        jndiObjectFactoryBean.setResourceRef(true);
//        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
//        return (DataSource)jndiObjectFactoryBean.getObject();
//    }
//}
