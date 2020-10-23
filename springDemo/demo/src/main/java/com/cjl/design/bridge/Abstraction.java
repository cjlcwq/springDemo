package com.cjl.design.bridge;

public abstract class Abstraction {
    private Implementor implementor;
    private Prand prand;
    public Abstraction(Implementor implementor, Prand prand){
        this.implementor = implementor;
        this.prand = prand;
    }
    public abstract void operation();
}
