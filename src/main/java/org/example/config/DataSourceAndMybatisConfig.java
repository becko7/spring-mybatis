package org.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//@Configuration
//@EnableTransactionManagement
public class DataSourceAndMybatisConfig {

//    @Bean(destroyMethod = "close")
//    public DataSource dataSource(HikariConfig hikariConfig) {
//        /*
////        HikariConfig hikariConfig = new HikariConfig();
////        hikariConfig.setDriverClassName();
////        hikariConfig.setJdbcUrl();
////        hikariConfig.setUsername();
////        hikariConfig.setPassword();
////        hikariConfig.setSchema();
//        */
//
//        return new HikariDataSource(hikariConfig);
//    }

//    @Bean
//    public SqlSessionFactory getReservationApiSqlSessionFactory(DataSource dataSource,
//                                                                ApplicationContext applicationContext) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
//        sqlSessionFactoryBean.setMapperLocations(
//                applicationContext.getResources("classpath*:mappers/**/*.xml"));
//
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean(destroyMethod = "clearCache")
//    public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean
//    public PlatformTransactionManager reservationApiTransactionManager(DataSource dataSource) {
//        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
//        transactionManager.setGlobalRollbackOnParticipationFailure(false);
//        return transactionManager;
//    }

}
