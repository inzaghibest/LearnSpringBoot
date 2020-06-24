package com.zhangxp.boot.controller;

import com.zhangxp.boot.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangxp on 2020/6/24.
 */
@RestController
public class payController {
    @Autowired
    private PayService payService;
    @RequestMapping(value= "/pay", method = RequestMethod.GET)
    public void pay() {
        payService.pay(2, 1,100);
    }

}
