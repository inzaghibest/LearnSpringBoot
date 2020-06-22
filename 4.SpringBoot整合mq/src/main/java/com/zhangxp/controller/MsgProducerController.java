package com.zhangxp.controller;

import com.zhangxp.service.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangxp on 2020/6/22.
 */
@RestController
public class MsgProducerController {
    @Autowired
    private MsgProducer msgProducer;

    @RequestMapping("/produce")
    public String produceMsg(String msg) {
         return msgProducer.sendMsg(msg);
    }

    @RequestMapping("/topicMan")
    public String topicMan() {
        return msgProducer.sendTopicMsg("man");
    }

    @RequestMapping("/topicWoman")
    public String topicWoMan() {
        return msgProducer.sendTopicMsg("woman");
    }

    @RequestMapping("/sendFanout")
    public String sendFanout() {
        return msgProducer.sendFanoutMsg();
    }
}
