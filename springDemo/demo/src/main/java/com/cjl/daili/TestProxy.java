package com.cjl.daili;

public class TestProxy {
    public static void main(String[] args) {
        SubjectProxy subjectProxy = new SubjectProxy();
        Subject sub = (Subject) subjectProxy.bind(new RealSubject());
        sub.doSomething();
    }
}
