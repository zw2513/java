package zw.example.learn.service.hello.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import zw.example.learn.service.hello.config.props.MyBatisConfigProp;

import javax.sql.DataSource;

/**
 * Created by zw on 2017/2/12 13:13.
 */
@Configuration
@MapperScan(basePackages = "zw.example.learn.service.hello.mapper"
)
@ConditionalOnBean(DataSource.class)
@ConditionalOnClass(value = {SqlSessionFactory.class,SqlSessionFactoryBean
        .class})
@ConditionalOnMissingBean(SqlSessionFactory.class)
public class MyBatisConfig {

    @Bean
    @Primary
    public MybatisProperties mybatisProperties(MyBatisConfigProp prop){
        MybatisProperties mProp = new MybatisProperties();

        mProp.setMapperLocations(new String[]{prop.getMapperLocations()});

        return mProp;
    }

    @Bean
    @ConditionalOnMissingBean
    public TransactionFactory transactionFactory() {
        return new JdbcTransactionFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource,
                                               TransactionFactory factory,
                                               MybatisProperties prop)
            throws Exception{

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();

        bean.setDataSource(dataSource);
//        bean.setTransactionFactory(factory);
        bean.setMapperLocations(prop.resolveMapperLocations());

        return bean.getObject();
    }
}
