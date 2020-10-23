package com.cjl.spring.service;

import com.cjl.spring.annotation.MyComponent;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author chen jingling
 * @Date 2020/10/22 16:38
 */
@MyComponent
public class UserService {

    public void getUser(){
        System.out.println("spring get UserSerivce getUser");
    }
}
