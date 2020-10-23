package com.cjl.design.Strategy;

public class Car implements Travel {
    @Override
    public void traffic() {
        System.out.println("我带你开车");
    }
}
