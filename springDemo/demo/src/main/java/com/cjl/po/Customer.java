package com.cjl.po;

/**
 * @ClassName Customer
 * @Description TODO
 * @Author chen jingling
 * @Date 2020/10/20 10:29
 */
public class Customer {

    private Long id;
    private String name;
    private int age;

    public Customer(){}

    public Customer(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
