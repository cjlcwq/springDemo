package com.cjl.design.builder;

public class createBuilder1 extends Builder {
    @Override
    public void buildPart1() {
        product.setPart1("建造轮胎");
    }

    @Override
    public void buildPart2() {
        product.setPart2("建造引擎");
    }

    @Override
    public void buildPart3() {
        product.setPart3("建造车身");
    }
}
