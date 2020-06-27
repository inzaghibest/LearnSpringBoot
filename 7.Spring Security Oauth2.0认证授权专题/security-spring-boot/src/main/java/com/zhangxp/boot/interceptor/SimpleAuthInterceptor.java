package com.zhangxp.boot.interceptor;

import com.zhangxp.boot.entity.MyUser;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2020/6/25 0025.
 * 自定义拦截器实现简单的权限控制示例。
 */
@Component
public class SimpleAuthInterceptor implements HandlerInterceptor {
    // 调用方法之前调用这个方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object object = request.getSession().getAttribute(MyUser.SESSION_USER_KEY);
        if (object == null)
        {
            writeContent(response, "请登录");
        }
        MyUser myUser = (MyUser)object;
        if (myUser.getAuthorites().contains("p1") && request.getRequestURI().contains("/r/r1"))
        {
            return true;
        }else if (myUser.getAuthorites().contains("p2") && request.getRequestURI().contains("/r/r2"))
        {
            return true;
        }
        writeContent(response, "没有权限，拒绝访问!");
        return false;
    }

    // 响应信息给客户端
    @ResponseBody
    private void writeContent(HttpServletResponse response, String msg) throws IOException{
        System.out.print("---------writeContent()---------------");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(msg);
        printWriter.close();
        response.resetBuffer();
    }
}
