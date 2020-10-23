package com.cjl.design.AbstractFactory;

public class DSJFactory implements AbstractFactory {
    @Override
    public HaierProduct Haierproduct() {
        return new haier1();
    }

    @Override
    public TCLProduct TCLproduct() {
        return new TCL1();
    }
}
