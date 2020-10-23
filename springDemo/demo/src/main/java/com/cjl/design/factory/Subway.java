package com.cjl.design.factory;

public class Subway implements Produce {
    @Override
    public void make() {
        System.out.println("生产地铁");
    }
}
