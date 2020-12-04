package com.lih.work;

import com.lih.util.RabbitUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author:lih
 * @Description:
 * @Date:2020/12/04 19:36
 */
public class Consumer {

    public static void main(String[] args)throws Exception {
        Connection connection = RabbitUtil.getConnection();
        //设置队列参数:队列名称,是否持久化,是否独占队列,是否自动删除,额外参数
        Channel channel = connection.createChannel();
        //声明队列名
        //声明队列名
        String queueName="workQueue";
        channel.queueDeclare(queueName, true, false, false, null);

        //设置每秒分配
        //channel.basicQos(1);
        //创建消费者对象
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String s = new String(body);
                System.out.println("消费者 1 获取的消息:" + s);

                //设置手动发送回执
                //channel.basicAck(envelope.getDeliveryTag(), false);
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        //设置消费者获取消息参数:队列名称,是否自动发送回执,消费者对象
        channel.basicConsume(queueName,false,defaultConsumer);


    }
}
