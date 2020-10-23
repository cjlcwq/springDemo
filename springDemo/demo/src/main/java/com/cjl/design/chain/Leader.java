package com.cjl.design.chain;

public abstract class Leader {
    private Leader next;
    public void setNext(Leader next){
        this.next = next;
    }
    public Leader getNext(){
        return next;
    }
    public abstract void handleRequest(int leaveDays);
}
