package com.cjl.design.factory;

public class Car implements Produce {
    @Override
    public void make() {
        System.out.println("生产汽车");
    }
}
