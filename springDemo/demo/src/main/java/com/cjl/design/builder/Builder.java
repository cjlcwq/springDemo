package com.cjl.design.builder;

public abstract class Builder {
    Product product = new Product();
    public abstract void buildPart1();
    public abstract void buildPart2();
    public abstract void buildPart3();
    public Product getResult(){
        return product;
    }
}
