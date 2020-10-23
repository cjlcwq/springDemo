package com.cjl.design.factory;

public class SubwayFactory implements AbstractFactory {
    @Override
    public Produce createProduce() {
        return new Subway();
    }
}
