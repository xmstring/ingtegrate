package com.multi.datasource.integrate.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 第二个数据源同理，创建一个新的配置类，将 MapperScan 的路径改为 map2，bean 的注入也要对那个的修改
 */

@Configuration
@MapperScan(value = "com.multi.datasource.integrate.mapper.mapper2",sqlSessionFactoryRef = "sqlSessionFactoryBean2")
public class MyBatisConfigTwo {

    @Autowired
    @Qualifier("dataSource2")
    DataSource db2;
/*
* 获取会话连接
* */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(db2);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:./mapper/mapper2/*.xml"));
        return factoryBean.getObject();
    }
/*
* 设置操作模板参数
* */
    @Bean
    SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean2());
    }
/*
* 开启事务管理
* */
   /* @Bean(name = "dataSource2TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("dataSource2") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/
}
