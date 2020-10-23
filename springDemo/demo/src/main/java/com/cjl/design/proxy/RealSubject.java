package com.cjl.design.proxy;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("这里是真是主题");
    }
}
