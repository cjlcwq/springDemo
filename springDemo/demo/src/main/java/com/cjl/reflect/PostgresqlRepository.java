package com.cjl.reflect;

public class PostgresqlRepository implements IRepository {
    @Override
    public void save(String str) {
        System.out.println("这里是传输到postgresql的实现类" + str);
    }
}
