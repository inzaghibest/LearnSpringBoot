package com.zhangxp.service;

//import com.zhangxp.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zhangxp on 2020/6/22.
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("TestDirectQueue"))
public class MsgReceiverNew {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(Map<String, Object> map) {
        logger.info("------MsgReceiverNew消费消息:-------------" + map.toString());
    }
}
