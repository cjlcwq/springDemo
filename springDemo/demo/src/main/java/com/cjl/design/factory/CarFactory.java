package com.cjl.design.factory;

public class CarFactory implements AbstractFactory {
    @Override
    public Produce createProduce() {
        return new Car();
    }
}
