package com.cjl.spring.service;

import com.cjl.spring.annotation.MyAutowire;
import com.cjl.spring.annotation.MyComponent;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author chen jingling
 * @Date 2020/10/22 21:21
 */
@MyComponent
public class OrderService {

    @MyAutowire
    private UserService userService;

    public void getOrder(){
        userService.getUser();
    }
}
