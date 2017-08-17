package com.csy.springboot.domain;

/**
 * Created by chenshengyu
 * on 2017/8/16.
 */
public class Mail {
    private String mail;
    private int code;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public  boolean isEmail() {

        return mail.matches("^[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$");
    }
}
