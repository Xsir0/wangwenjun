package com.example.wangwenjun.activeobject;

import com.example.wangwenjun.futuretask.Future;

public interface OrderService {

    Future<String> findOrderDetails(long orderId);


    void order(String account,long orderId);

}
