package com.cjl.design.bridge;

public class ConcreteImplementorB implements Implementor {
    @Override
    public void OperationImpl() {
        System.out.println("这个包为黄色");
    }
}
