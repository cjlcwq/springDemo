package com.cjl.design.template;

public abstract class Template {
    public void quHao(){
        System.out.println("客户进行取号");
    }
    public void paiDui(){
        System.out.println("客户进行排队");
    }
    public abstract void yeWu();
    public void pingFen(){
        System.out.println("客户进行评分");
    }
}
