package com.lih.routing;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author:lih
 * @Description:
 * @Date:2020/12/04 21:21
 */
@Component
public class RoutingConsumer {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "Springbt-routing",type = "direct"),
            key = {"error"}
    ))
    public void receive1(String message){
        System.out.println("消费者 1 消费消息: "+message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "Springbt-routing",type = "direct"),
            key = {"error","info"}
    ))
    public void receive2(String message){
        System.out.println("消费者 1 消费消息: "+message);
    }
}
