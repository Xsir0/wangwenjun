package com.example.wangwenjun.classloader;

/**
 * @ClassName HelloWorld
 * @Description
 * @Author xsir
 * @Date 2021/9/19 下午12:55
 * @Version V1.0
 */
public class HelloWorld {

    static {
        System.out.println("Hello World Class is Initialized");
    }

    public String welcome(){
        return "Hello World1";
    }

}
