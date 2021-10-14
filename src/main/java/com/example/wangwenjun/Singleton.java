package com.example.wangwenjun;

/**
 * @ClassName Singleton
 * @Description ① 跟 ② 位置不一样，输出结果不一样
 * @Author xsir
 * @Date 2021/9/18 上午6:15
 * @Version V1.0
 */
public class Singleton {


    private static  int y;

    // ①
    private static Singleton instance = new Singleton();

    // ②
    private static int x = 0;

    private Singleton(){
        x++;
        y++;
    }
    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }

}
