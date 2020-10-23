package com.cjl.reflect;

public class MysqlRepository implements IRepository {
    @Override
    public void save(String str) {
        System.out.println("这里是传输到mysql的实现类" + str);
    }
}
