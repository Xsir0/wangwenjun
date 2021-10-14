package com.example.wangwenjun.twophasetermination;

/**
 * @ClassName Reference
 * @Description
 * @Author xsir
 * @Date 2021/9/29 上午6:26
 * @Version V1.0
 */
public class Reference {

    private final byte[] data = new byte[2<<9];

    @Override
    protected void finalize() throws Throwable {
        System.out.println("the reference will be GC.");
    }

}
