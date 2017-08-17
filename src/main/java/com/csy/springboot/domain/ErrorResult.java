package com.csy.springboot.domain;

/**
 * Created by chenshengyu
 * on 2017/8/14.
 */
public class ErrorResult  {
    private String error;
    private int status;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setResult(String result) {
        this.error = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }
}
