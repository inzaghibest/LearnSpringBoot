package com.zhangxp.service;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxp on 2020/6/22.
 */
@Component
public class MyAckReceiver implements ChannelAwareMessageListener {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            // 因为传递消息的时候用的map传递,所以将Map从Message内取出需要做些处理
//            String msg = message.toString();
//            String[] msgArray = msg.split("'"); // 可以点击Message里面看源码,单引号之间的数据就是我们的map消息数据
//            Map<String, String> msgMap = mapStringToMap(msgArray[1].trim());
//            String messageId = msgMap.get("messageId");
//            String messageData=msgMap.get("mesageData");
//            String createTime = msgMap.get("createTime");
//            logger.info("MyAckReceiver meesageId:" + messageId + "messageData:" + messageData
//            + "createTime: " +createTime);
            logger.info("消费的主题消息来自: " + message.getMessageProperties().getConsumerQueue());
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            channel.basicReject(deliveryTag, false);
            e.printStackTrace();
        }
    }

    //{key=value,key=value,key=value} 格式转换成map
    private Map<String, String> mapStringToMap(String str) {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",");
        Map<String, String> map = new HashMap<String, String>();
        for (String string : strs) {
            String key = string.split("=")[0].trim();
            String value = string.split("=")[1];
            map.put(key, value);
        }
        return map;
    }
}
