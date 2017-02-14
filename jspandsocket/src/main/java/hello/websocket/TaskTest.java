package hello.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by zw on 2017/2/14 20:50.
 */
@Component
public class TaskTest {

    private SimpMessagingTemplate template;


    @Autowired
    TaskTest(
            SimpMessagingTemplate a_template) {
        this.template = a_template;
    }

    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(2);
                this.template.convertAndSend("/topic/greetings",new
                        Greeting("hello "));
            } catch (Exception ex) {

            }
        }
    }
}
