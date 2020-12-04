package com.lih.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author:lih
 * @Description:
 * @Date:2020/12/04 21:13
 */
@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue(value = "springBoot-work",autoDelete = "true"))
    public void receive(String message){
        System.out.println("消费者 1 消费消息: "+message);
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "springBoot-work",autoDelete = "true"))
    public void receive1(String message){
        System.out.println("消费者 2 消费消息: "+message);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
