package com.cjl.csdn;

public class EqualsAndHashCode {
    public static void main(String[] args) {
        Student test1 = new Student("test1", 18);
        Student test2 = new Student("test1", 18);
        boolean result = test1.equals(test2);
        System.out.println("未重写equals和hashCode的结果为：" + result);
        System.out.println("test1的hash值：" + test1.hashCode());
        System.out.println("test2的hash值：" + test2.hashCode());
    }
}
