package com.study;

public class TestService {

    private String msg;

    public String sayHello(){
        return "hello" + msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
