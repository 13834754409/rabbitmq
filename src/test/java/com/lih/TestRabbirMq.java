package com.lih;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author:lih
 * @Description:
 * @Date:2020/12/04 21:02
 */
@SpringBootTest
public class TestRabbirMq {
    @Autowired
    RabbitTemplate rabbitTemplate;

    //hello world
    @Test
    public void test0(){
        //发布消息  参数:队列名称,发送内容
        rabbitTemplate.convertAndSend("springBoot-Queues","你好Springboot-Hello World");
        System.out.println("=== send success ===");
    }

    //work
    @Test
    public void test1(){
        //发布消息  参数:队列名称,发送内容
        for (int i = 0; i < 20; i++) {
            rabbitTemplate.convertAndSend("springBoot-work", "你好Springboot-Hello World"+i);
            System.out.println("=== send success ===");
        }
    }

    //fanout
    @Test
    void direct() {
        //发布消息  参数:交换机名,路由key,内容
        rabbitTemplate.convertAndSend("Springbt-logs","","你好SpringBoot fanout");
        System.out.println("== send success ===");
    }


    //routing
    @Test
    void routing() {
        //发布消息  参数:交换机名,路由key,内容
        rabbitTemplate.convertAndSend("Springbt-routing","info","你好SpringBoot routing");
        System.out.println("== send success ===");
    }

    //topic
    @Test
    void topic() {
        //发布消息  参数:交换机名,路由key,内容
        rabbitTemplate.convertAndSend("Springbt-topic","user.add.aaa","你好SpringBoot topic");
        System.out.println("== send success ===");
    }
}
