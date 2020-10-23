package com.cjl.design.bridge;

public class ConcreteImplementorA implements Implementor {
    @Override
    public void OperationImpl() {
        System.out.println("这个包为红色");
    }
}
