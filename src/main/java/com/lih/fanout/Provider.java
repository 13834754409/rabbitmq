package com.lih.fanout;

import com.lih.util.RabbitUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author:lih
 * @Description:
 * @Date:2020/12/04 19:36
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        Connection connection = RabbitUtil.getConnection();
        //设置队列参数:队列名称,是否持久化,是否独占队列,是否自动删除,额外参数
        Channel channel = connection.createChannel();
        //交换机名称
        String exchangeName = "logs";
        //设置交换机参数  参数:交换机名称,交换机类型  fanout:广播
        channel.exchangeDeclare(exchangeName,"fanout");

        //设置消息
        String message = "create exchange fanout";
        //发布消息:交换机名称,路由key,是否持久化队列,消息内容
        channel.basicPublish(exchangeName,"",null,message.getBytes());

        //关闭资源
        RabbitUtil.closeConnection(channel, connection);

    }
}
