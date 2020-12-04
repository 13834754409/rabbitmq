package com.lih.fanout;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author:lih
 * @Description:
 * @Date:2020/12/04 21:17
 */
@Component
public class FanoutConsumer {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "Springbt-logs",type = "fanout")
    ))
    public void receive1(String message){
        System.out.println("消费者 1 消费消息: "+message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "Springbt-logs",type = "fanout")
    ))
    public void receive2(String message){
        System.out.println("消费者 1 消费消息: "+message);
    }
}
