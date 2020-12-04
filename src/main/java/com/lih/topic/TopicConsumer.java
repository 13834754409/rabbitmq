package com.lih.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author:lih
 * @Description:
 * @Date:2020/12/04 21:17
 */
@Component
public class TopicConsumer {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "Springbt-topic",type = "topic"),
            key = {"user.*"}
    ))
    public void receive1(String message){
        System.out.println("消费者 1 消费消息: "+message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "Springbt-topic",type = "topic"),
            key = {"user.#"}
    ))
    public void receive2(String message){
        System.out.println("消费者 1 消费消息: "+message);
    }
}
