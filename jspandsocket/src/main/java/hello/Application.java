package hello;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class Application {
  static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        ApplicationContext context =
                new SpringApplicationBuilder()
                .sources(Application.class)
                .run(args);

        TaskTest taskTest = context.getBean(TaskTest.class);
        taskTest.run();

        try {
            latch.await();
        }catch (InterruptedException ex){

        }
    }
}
