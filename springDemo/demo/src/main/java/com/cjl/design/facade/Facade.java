package com.cjl.design.facade;

public class Facade {
    private SubSystem1 part1 = new SubSystem1();
    private SubSystem2 part2 = new SubSystem2();
    private SubSystem3 part3 = new SubSystem3();
    public void method(){
        part1.method();
        part2.method();
        part3.method();
    }
}
