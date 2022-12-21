/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.mycompany.schoolwebapp")
public class HibernateConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(false)
                .setName("testdb")
                .setType(EmbeddedDatabaseType.H2)
                .addDefaultScripts()
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .build();
    }

    @Bean
    public NamedParameterJdbcTemplate namedParamJdbcTemplate() {
        NamedParameterJdbcTemplate namedParamJdbcTemplate
                = new NamedParameterJdbcTemplate(dataSource());
        return namedParamJdbcTemplate;
    }

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
////        dataSource.setUrl("jdbc:mysql://localhost:3306/school?autoReconnect=true&useSSL=false");
////        dataSource.setUsername("root");
////        dataSource.setPassword("root");
//
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:C:/data/sampledata");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
//
//        return dataSource;
//
//    }
    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.mycompany.schoolwebapp.model"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties p = new Properties();
        // p.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        p.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        p.put("hibernate.show_sql", "true");
        p.put("spring.h2.console.enabled", "true");
        return p;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManger(SessionFactory s) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(s);
        return hibernateTransactionManager;
    }

}
