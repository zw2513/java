package zw.example.learn.service.hello.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zw.example.learn.HelloServiceApp;
import zw.example.learn.service.hello.HelloService;
import zw.example.learn.service.hello.config.HelloServiceConfig;

import static org.junit.Assert.assertNotNull;

/**
 * Created by zw on 2017/2/12 11:30.
 */
@SpringBootTest(classes = HelloServiceApp.class)
@RunWith(SpringRunner.class)
public class HelloServiceIntegrationTests {
    @Autowired
    private HelloServiceConfig config;

    @Autowired
    private HelloService helloService;

    @Test
    public void shouldInjectConfigProperties(){
        assertNotNull(config);
        assertNotNull(config.getName());
    }
}
