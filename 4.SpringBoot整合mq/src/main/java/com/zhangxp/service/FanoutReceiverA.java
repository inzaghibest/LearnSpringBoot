package com.zhangxp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zhangxp on 2020/6/22.
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RabbitHandler
    public void process(Map message) {
        logger.info("------------FanoutReceiverA消费消息:-------------" + message.toString());
    }
}
