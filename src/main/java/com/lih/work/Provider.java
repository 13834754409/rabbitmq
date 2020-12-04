package com.lih.work;

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
        //声明队列名
        String queueName = "workQueue";
        channel.queueDeclare(queueName, true, false, false, null);

        for (int i = 0; i < 20; i++) {
            //发布消息
            String messsge="create work queue == "+i;
            //发布消息:交换机名称,队列名,是否持久化队列,消息内容
            channel.basicPublish("",queueName,null,messsge.getBytes());
        }
        //关闭资源
        RabbitUtil.closeConnection(channel,connection);

    }
}
