package zw.example.learn.service.hello.config.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zw on 2017/2/12 13:34.
 */
@Configuration
@ConfigurationProperties(locations = {"classpath:hello.service.properties"},
prefix = "mybatis")
public class MyBatisConfigProp {
    private String mapperLocations;

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }
}
