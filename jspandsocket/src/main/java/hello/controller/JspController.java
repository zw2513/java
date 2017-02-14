package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zw on 2017/2/14 21:50.
 */
@Controller
public class JspController {

    @GetMapping("/jsp")
    public String hello(){
        return "hello";
    }
}
