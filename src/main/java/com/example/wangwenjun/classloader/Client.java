package com.example.wangwenjun.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName Client
 * @Description
 * @Author xsir
 * @Date 2021/9/19 下午12:56
 * @Version V1.0
 */
public class Client {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        // 不需要删除文件的做法
        ClassLoader extClassLoader = MyClassLoader.class.getClassLoader().getParent();
        MyClassLoader myClassLoader = new MyClassLoader("/Users/xsir/Desktop/test/",extClassLoader);
        // 需要删除文件的做法
        // MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass("com.example.wangwenjun.classloader.HelloWorld");
        System.out.println(aClass.getClassLoader());

        Object helloWorld = aClass.newInstance();

        System.out.println(helloWorld);

        Method welcome = aClass.getMethod("welcome");

        String invoke = (String) welcome.invoke(helloWorld);

        System.out.println("Result: "+invoke);

    }

}
