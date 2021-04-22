package com.hxq.configtion;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//代替bean.xml文件的注解类
@Configuration
//spring扫描的包
@ComponentScan("com.hxq")
//@value获取配置文件的类路径
@PropertySource("classpath:jdbcConfig.properties")
public class conf {
    @Value("${jdbc.url}")
    public String jdbcurl;
    @Value("${jdbc.username}")
    public String jdbcname;
    @Value("${jdbc.password}")
    public String jdbcpd;
    @Value("${jdbc.driver}")
    public String jdbcdriver;

@Bean(name="runner")
@Scope("prototype")
    public QueryRunner queryRunner(){
        return new QueryRunner();
    }

    @Bean(name="datasource")
    public DataSource creatdataSource() throws PropertyVetoException {
        ComboPooledDataSource ds=new ComboPooledDataSource();
        ds.setDriverClass(jdbcdriver);
        ds.setJdbcUrl(jdbcurl);
        ds.setUser(jdbcname);
        ds.setPassword(jdbcpd);
        return ds;

    }
    @Bean
    public PlatformTransactionManager creatmanager(DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }
}
