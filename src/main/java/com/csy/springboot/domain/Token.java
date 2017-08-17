package com.csy.springboot.domain;

/**
 * Created by chenshengyu
 * on 2017/8/14.
 */
public class Token{
    private Long user_id;
    private String token;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
