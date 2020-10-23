package com.cjl.design.chain;

public class ClassAdviser extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays <= 2){
            System.out.println("班主任批准请假" + leaveDays);
        }
        else {
            if(getNext() != null){
                getNext().handleRequest(leaveDays);
            }else {
                System.out.println("请假天数过多，班主任无权批准");
            }
        }
    }
}
