package com.cjl.design.adapter;

public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request(){
        specificRequest();
    }
}
