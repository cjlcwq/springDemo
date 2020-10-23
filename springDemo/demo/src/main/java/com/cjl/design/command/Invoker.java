package com.cjl.design.command;

public class Invoker {
    private Command command;
    public Invoker(Command command){
        this.command = command;
    }
    public void call(){
        System.out.println("调用者执行command命令");
        command.execute();
    }
}
