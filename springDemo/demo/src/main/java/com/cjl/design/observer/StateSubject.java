package com.cjl.design.observer;

public class StateSubject extends NaoLingSubject {
    @Override
    public void notifyObserve() {
        System.out.println("闹铃响了");
        for (Observer observer : list) {
            observer.response();
        }
    }
}
