package com.multi.datasource.integrate.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.multi.datasource.integrate.pojo.Db1Config;
import com.multi.datasource.integrate.pojo.Db2Config;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import java.sql.SQLException;

@Configuration
public class DataSourceConfig {
    @Primary
    @Bean("dataSource1")
    public DataSource db1DataSource(Db1Config db1Config ) throws SQLException {
        System.out.println(db1Config );
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(db1Config .getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(db1Config .getPassword());
        mysqlXaDataSource.setUser(db1Config .getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        //注册到全局事务
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName(db1Config .getUniqueResourceName());
        xaDataSource.setMinPoolSize(db1Config .getMinPoolSize());
        xaDataSource.setMaxPoolSize(db1Config .getMaxPoolSize());
        xaDataSource.setMaxLifetime(db1Config .getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(db1Config .getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(db1Config .getLoginTimeout());
        xaDataSource.setMaintenanceInterval(db1Config .getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(db1Config .getMaxIdleTime());
        xaDataSource.setTestQuery(db1Config .getTestQuery());
        return xaDataSource;
    }
    @Bean("dataSource2")
    public DataSource orderDataSource(Db2Config db2Config ) throws SQLException {
        System.out.println(db2Config );
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(db2Config .getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(db2Config .getPassword());
        mysqlXaDataSource.setUser(db2Config .getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        //注册到全局事务
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName(db2Config .getUniqueResourceName());
        xaDataSource.setMinPoolSize(db2Config .getMinPoolSize());
        xaDataSource.setMaxPoolSize(db2Config .getMaxPoolSize());
        xaDataSource.setMaxLifetime(db2Config .getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(db2Config .getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(db2Config .getLoginTimeout());
        xaDataSource.setMaintenanceInterval(db2Config .getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(db2Config .getMaxIdleTime());
        xaDataSource.setTestQuery(db2Config .getTestQuery());
        return xaDataSource;
    }
    /**
     * JTA 事务管理器
     * @return
     */
    @Bean("xaTransaction")
    public JtaTransactionManager jtaTransactionManager(){
        UserTransaction userTransaction = new UserTransactionImp();
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        return  new JtaTransactionManager(userTransaction, userTransactionManager);
    }
}
