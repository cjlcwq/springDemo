package com.cjl.design.AbstractFactory;

public class KTFactory implements AbstractFactory {
    @Override
    public HaierProduct Haierproduct() {
        return new haier2();
    }

    @Override
    public TCLProduct TCLproduct() {
        return new TCL2();
    }
}
