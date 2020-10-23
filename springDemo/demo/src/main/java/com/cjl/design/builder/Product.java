package com.cjl.design.builder;

public class Product {
    String part1;
    String part2;
    String part3;

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }
    public void show(){
        System.out.println(this.part1 + "  " + this.part2 + "  " + this.part3 + "  " + "组成了汽车");
    }
}
