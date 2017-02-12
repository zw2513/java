package zw.example.learn.service.hello.config.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zw on 2017/2/12 12:43.
 */
@Configuration
@ConfigurationProperties(locations = "classpath:hello.service.properties",
prefix = "jdbc")
public class DataSourceConfigProp {
    private String url;

    private String user;

    private String password;

    private String driver;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwod) {
        this.password = passwod;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
