package com.cjl.csdn;

import java.util.Objects;

public class Student {
    String name;
    Integer age;

    public Student(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) &&
                age.equals(student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
