package com.zhangxp.boot.entity;

/**
 * Created by zhangxp on 2020/6/24.
 */
public class AuthenticationRequest {
    private String username;
    private String password;

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
