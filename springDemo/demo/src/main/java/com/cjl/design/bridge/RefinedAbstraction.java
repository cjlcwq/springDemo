package com.cjl.design.bridge;

public class RefinedAbstraction extends Abstraction {
    private Implementor implementor;
    private Prand prand;
    public RefinedAbstraction(Implementor implementor, Prand prand) {
        super(implementor, prand);
        this.implementor = implementor;
        this.prand = prand;
    }

    @Override
    public void operation() {
        prand.prandType();
        System.out.println("这是种挎包");
        implementor.OperationImpl();
    }
}
