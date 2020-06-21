package com.zhangxp.api.controller;

/**
 * Created by Administrator on 2020/6/21 0021.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;
@Controller
public class IndexController {
    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        return "我是index控制类!";
    }

    @RequestMapping("/freemarkerIndex")
    public String freemarkerIndex(Map<Object, Object> resultMap) {
        resultMap.put("name", "张晓平");
        resultMap.put("sex", "1");
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("zhangxp");
        objects.add("spring boot");
        resultMap.put("objects", objects);
        return "freemarkerIndex";
    }
}
