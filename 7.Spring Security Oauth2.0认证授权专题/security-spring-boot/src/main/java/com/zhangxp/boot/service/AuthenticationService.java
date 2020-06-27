package com.zhangxp.boot.service;

import com.zhangxp.boot.entity.AuthenticationRequest;
import com.zhangxp.boot.entity.MyUser;
import com.zhangxp.boot.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
public class AuthenticationService {
    @Autowired
    private MyUserMapper myUserMapper;

    /**
     * 校验用户信息
     */
    public MyUser authentication(AuthenticationRequest authenticationRequest) {
        if (authenticationRequest == null ||
                StringUtils.isEmpty(authenticationRequest.getUsername())
                || StringUtils.isEmpty(authenticationRequest.getUsername())) {
            throw new RuntimeException("账号或密码为空!");
        }
        MyUser myUserDto = new MyUser();
        myUserDto.setUsername(authenticationRequest.getUsername());
//        myUserDto.setPassword(authenticationRequest.getPassword());
        List<MyUser> myUserList = myUserMapper.select(myUserDto);
        if (myUserList.size() == 0) {
            throw new RuntimeException("查询不到该用户!");
        }
        if (!authenticationRequest.getPassword().equals(myUserList.get(0).getPassword())) {
            throw new RuntimeException("用户密码错误!");
        }
        System.out.println(myUserList.get(0).toString());
        return myUserList.get(0);
    }
}