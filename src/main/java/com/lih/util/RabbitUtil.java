package com.lih.util;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author:lih
 * @Description:
 * @Date:2020/12/03 20:58
 */
public class RabbitUtil {
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    static {
        //创建连接工厂
        //设置Rabbitmq的ip地址
        connectionFactory.setHost("10.23.0.5");
        //设置RabbitMQ端口
        connectionFactory.setPort(5672);
        //设置虚拟主机名
        connectionFactory.setVirtualHost("/yingx");
        //设置用户密码
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
    }
    //获取连接
    public static Connection getConnection(){
        //通过连接工厂创建连接
        Connection connection = null;
        try {
            connection = connectionFactory.newConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    //关闭连接
    public static void closeConnection(Channel channel,Connection connection){
        try {
            if(channel!=null)channel.close();
            if(connection!=null)connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
