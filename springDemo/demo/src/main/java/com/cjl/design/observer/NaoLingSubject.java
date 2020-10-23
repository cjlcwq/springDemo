package com.cjl.design.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class NaoLingSubject {
    public List<Observer> list = new ArrayList();
    public void add(Observer observer){
        list.add(observer);
    }
    public void remove(Observer observer){
        list.remove(observer);
    }
    public abstract void notifyObserve();
}
