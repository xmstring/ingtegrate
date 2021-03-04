package com.multi.datasource.integrate.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
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
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;

/**
 * 第二个数据源同理，创建一个新的配置类，将 MapperScan 的路径改为 map2，bean 的注入也要对那个的修改
 */

@Configuration
@MapperScan(value = "com.multi.datasource.integrate.mapper.mapper1",sqlSessionFactoryRef = "sqlSessionFactoryBean1")
public class MyBatisConfigOne {

    @Autowired
    @Qualifier("dataSource1")
    DataSource db1;

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(db1);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:./mapper/mapper1/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean1());
    }

}
