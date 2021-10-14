package com.example.wangwenjun;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @ClassName ClassInit
 * @Description
 * @Author xsir
 * @Date 2021/9/18 上午8:20
 * @Version V1.0
 */
public class ClassInit {

    static {
        try {
            System.out.println("The ClassInt static code block will be invoke.");
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // IntStream.range(0,5).forEach(i->new Thread(ClassInit::new));

        System.out.println(System.getProperty("java.class.path"));
    }
}
