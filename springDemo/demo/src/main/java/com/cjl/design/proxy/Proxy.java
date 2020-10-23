package com.cjl.design.proxy;

public class Proxy implements Subject {
    @Override
    public void request() {
        System.out.println("这里是代理，对原有的进行增强");
        RealSubject realSubject = new RealSubject();
        realSubject.request();
        response();
    }
    public void response(){
        System.out.println("这是代理自己的方法");
    }
}
