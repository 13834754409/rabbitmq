package com.lih.topic;

import com.lih.util.RabbitUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author:lih
 * @Description:
 * @Date:2020/12/04 19:36
 */
public class Consumer1 {

    public static void main(String[] args) throws Exception {
        Connection connection = RabbitUtil.getConnection();
        //设置队列参数:队列名称,是否持久化,是否独占队列,是否自动删除,额外参数
        Channel channel = connection.createChannel();
        //交换机名称
        String exchangeName = "log-topic";
        //设置交换机参数  参数:交换机名称,交换机类型  fanout:广播
        channel.exchangeDeclare(exchangeName, "topic");
        //获取临时队列名
        String queueName = channel.queueDeclare().getQueue();

        //绑定队列 参数:队列名,交换机名,路由key
        channel.queueBind(queueName, exchangeName, "log.#");

        //创建消费者对象
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String s = new String(body);
                System.out.println("消费者 2 获取的消息:" + s);
            }
        };

        //设置消费者获取消息参数:队列名称,是否自动发送回执,消费者对象
        channel.basicConsume(queueName, true, defaultConsumer);

    }
}
