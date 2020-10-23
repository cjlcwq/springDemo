package com.cjl.design.chain;

public class DepartmentHead extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays <= 7){
            System.out.println("系主任批准请假" + leaveDays);
        }
        else {
            if(getNext() != null){
                getNext().handleRequest(leaveDays);
            }else {
                System.out.println("请假天数过多，系主任无权批准");
            }
        }
    }
}
