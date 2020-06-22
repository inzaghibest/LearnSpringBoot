package com.zhangxp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangxp on 2020/6/22.
 */
@Configuration
public class RabbitConfig {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        // 设置开启Mandatory,才能触发回调函数，无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                logger.info("ConfirmCallback:     " + "相关数据: " + correlationData);
                logger.info("ConfirmCallback:     " + "确认情况: " + b);
                logger.info("ConfirmCallback:     " + "原因: " + s);
            }
        });

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {
                logger.info("ReturnCallback:    " + "消息: " + message);
                logger.info("ReturnCallback:    " + "回应码: " + i);
                logger.info("ReturnCallback:    " + "回应信息: " + s);
                logger.info("ReturnCallback:    " + "交换机: " + s1);
                logger.info("ReturnCallback:    " + "路由键: " + s2);
            }
        });
        return rabbitTemplate;
    }
}
