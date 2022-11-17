package secondConsumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class SecondConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondConsumerApplication.class,args);
    }
}