package zw.example.learn.service.hello.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import zw.example.learn.HelloServiceApp;
import zw.example.learn.service.hello.HelloService;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.anyString;

/**
 * Created by zw on 2017/2/11 22:30.
 */
@SpringBootTest(classes = HelloServiceApp.class)
@RunWith(SpringRunner.class)
public class HelloServiceTests {

    @MockBean
    private HelloService helloService;

    @Test
    public void shouldReturnNonNullString(){
        final String res = "hello world";
        given(helloService.hello(anyString())).willReturn(res);

        String testRes = helloService.hello(res);

        then(helloService).should().hello(res);
        assertEquals(res,testRes);
    }
}
