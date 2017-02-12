package zw.example.learn.service.hello.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zw.example.learn.HelloServiceApp;
import zw.example.learn.service.hello.HelloService;
import zw.example.learn.service.hello.config.props.HelloServiceConfig;
import zw.example.learn.service.hello.model.Diary;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    private Integer id;


    @Before
    public void setUp(){
        id = addOne();
    }


    @After
    public void tearDown(){
        helloService.deleteAll();
        id = Integer.MIN_VALUE;
    }

    @Test
    @Ignore
    public void shouldInjectConfigProperties(){
        assertNotNull(config);
        assertNotNull(config.getName());
    }

    @Test
    public void testMyBatis(){
        assertNotNull(helloService.getById(id));
        assertTrue(assertListNotNullOrEmpty(helloService.getAll()));
    }

    boolean assertListNotNullOrEmpty(List<?> list){
        return list != null && list.size() > 0;
    }

    Integer addOne(){

        Diary diary = new Diary();
        diary.setContent("hello world");
        diary.setReadnum(0);
        diary.setTitle("hello world");
        diary.setTime(new Date());

        return helloService.add(diary);
    }
}
