package zw.example.learn.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zw.example.learn.service.hello.HelloService;

/**
 * Created by zw on 2017/2/11 22:27.
 */
@RestController
@RequestMapping("/hello")
class HelloController {
    private HelloService helloService;

    @Autowired
    HelloController(HelloService a_helloService){
        this.helloService = a_helloService;
    }

    @GetMapping("/name")
    public String getGreeting(@RequestParam(value = "name",required = false)
                              String name){
        return helloService.hello(name);
    }
}

