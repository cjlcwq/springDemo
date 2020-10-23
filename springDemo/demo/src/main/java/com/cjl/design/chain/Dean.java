package com.cjl.design.chain;

public class Dean extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays <= 10){
            System.out.println("院长批准请假" + leaveDays);
        }
        else {
            if(getNext() != null){
                getNext().handleRequest(leaveDays);
            }else {
                System.out.println("请假天数过多，院长无权批准");
            }
        }
    }
}
