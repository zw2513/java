package zw.example.learn.service.hello.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.example.learn.service.hello.config.props.DataSourceConfigProp;

/**
 * Created by zw on 2017/2/12 12:42.
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private DataSourceConfigProp configProp;


    @Bean
    public HikariDataSource dataSource(){
        HikariDataSource dataSource =
                new HikariDataSource();

        dataSource.setJdbcUrl(configProp.getUrl());
        dataSource.setUsername(configProp.getUser());
        dataSource.setPassword(configProp.getPassword());
        dataSource.setDriverClassName(configProp.getDriver());
        dataSource.setMaximumPoolSize(50);
        dataSource.setMinimumIdle(20);
        dataSource.setMaxLifetime(30000L);

        return dataSource;
    }
}
