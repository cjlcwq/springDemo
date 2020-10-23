package com.cjl.design.observer;

public class TeacherObserver implements Observer {
    @Override
    public void response() {
        System.out.println("老师要去给学生上课了");
    }
}
