package com.example.wangwenjun.workthread;

public abstract class InstructionBook {

    public final void create(){
        this.firstProcess();
        this.secondProcess();
    }

    protected abstract void firstProcess();
    protected abstract void secondProcess();

}
