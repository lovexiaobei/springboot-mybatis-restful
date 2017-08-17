package com.csy.springboot.domain;

/**
 * Created by chenshengyu
 * on 2017/8/14.
 */
public class Result<T> {
    private int status;
    private String result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
