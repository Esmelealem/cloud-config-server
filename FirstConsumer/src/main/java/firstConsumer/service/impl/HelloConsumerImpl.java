package firstConsumer.service.impl;

import firstConsumer.service.HelloConsumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class HelloConsumerImpl implements HelloConsumer {
    @Override
    @RabbitListener(queues = {"hello-queue-1"})
    public void bindToHelloQueue(String payload) {
        System.out.println(payload);

    }
}
