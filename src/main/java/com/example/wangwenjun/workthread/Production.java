package com.example.wangwenjun.workthread;

/**
 * @ClassName Production
 * @Description
 * @Author xsir
 * @Date 2021/10/8 上午6:39
 * @Version V1.0
 */
public class Production extends InstructionBook {

    // 产品编号
    protected final int prodID;

    public Production(int prodID){
        this.prodID = prodID;
    }

    @Override
    protected void firstProcess() {
        System.out.println("execute the "+ prodID+" first process");
    }

    @Override
    protected void secondProcess() {
        System.out.println("execute the "+ prodID+" second process");
    }
}
