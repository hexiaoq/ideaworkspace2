package com.atguigu.springcloud;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @auther zzyy
 * @create 2019-12-11 16:58
 * 使用Seata对数据源进行代理
 */
@Configuration
@Slf4j
public class DataSourceProxyConfig {



    @Bean
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://47.98.210.55:3306/seata_storage?serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("156437734");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //这上面是获取配置文件中的信息，url,username,password,driverclassname等
        return dataSource;
    }

    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSource(DataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }


}
