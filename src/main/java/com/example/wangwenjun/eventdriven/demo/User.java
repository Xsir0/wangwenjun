package com.example.wangwenjun.eventdriven.demo;

/**
 * @ClassName User
 * @Description
 * @Author xsir
 * @Date 2021/10/14 上午8:29
 * @Version V1.0
 */
public class User {

    private final String name;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
