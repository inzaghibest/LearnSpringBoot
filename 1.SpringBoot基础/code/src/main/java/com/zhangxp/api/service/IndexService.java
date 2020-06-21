package com.zhangxp.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/6/21 0021.
 */
@RestController
public class IndexService {

    @RequestMapping("/")
    public Map<String, String> index(){
        Map<String, String> mapData = new HashMap<String, String>();
        mapData.put("respCode", "200");
        mapData.put("respMessage", "请求成功");
        return mapData;
    }

    //    如果在项目中报错404, 如何解决?

}
