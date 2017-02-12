package zw.example.learn.service.hello.impl;

import org.springframework.stereotype.Service;
import zw.example.learn.service.hello.HelloService;

/**
 * Created by zw on 2017/2/11 22:29.
 */
@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        if (name == null || name.isEmpty()){
            name = "world";
        }

        return "hello" + name;
    }
}
