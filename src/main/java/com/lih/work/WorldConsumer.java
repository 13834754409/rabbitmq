package com.lih.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author:lih
 * @Description:
 * @Date:2020/12/04 21:04
 */
@RabbitListener(queuesToDeclare = @Queue(value = "springBoot-Queues",declare = "true",autoDelete = "true"))
@Component
public class WorldConsumer {

    @RabbitHandler
    public void receive(String message){
        System.out.println("消费者消费消息: "+message);
    }
}
