package com.cjl.design.Strategy;

public class Plane implements Travel {
    @Override
    public void traffic() {
        System.out.println("我带你坐飞机");
    }
}
