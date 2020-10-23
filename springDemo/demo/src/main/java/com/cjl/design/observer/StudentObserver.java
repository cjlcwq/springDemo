package com.cjl.design.observer;

public class StudentObserver implements Observer {
    @Override
    public void response() {
        System.out.println("学生该回到教室上课了");
    }
}
