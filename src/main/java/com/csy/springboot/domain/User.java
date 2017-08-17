package com.csy.springboot.domain;

/**
 * Created by chenshengyu
 * on 2017/8/11.
 */
public class User {

    /**
     * 用户ID
     */
    private Long id;


    /**
     * 城市名称
     */
    private String username;

    /**
     * 描述
     */
    private String description;

    private String pwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
