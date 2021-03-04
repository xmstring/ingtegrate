package com.multi.datasource.integrate;

import com.multi.datasource.integrate.pojo.Db1Config;
import com.multi.datasource.integrate.pojo.Db2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement // 配置的 事务注解的开发
@SpringBootApplication
@EnableConfigurationProperties({Db1Config.class, Db2Config.class})
public class IntegrateApplication {

    public static void main(String[] args) {
        System.out.println("多数据源整合");
        SpringApplication.run(IntegrateApplication.class, args);
    }

}
