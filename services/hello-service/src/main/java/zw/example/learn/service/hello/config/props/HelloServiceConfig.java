package zw.example.learn.service.hello.config.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zw on 2017/2/12 11:29.
 */
@Configuration
@ConfigurationProperties(locations = {"classpath:hello.service.properties"},
prefix = "hello")
public class HelloServiceConfig {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
