package com.example.wangwenjun.activeobject;

import com.example.wangwenjun.futuretask.Future;
import com.example.wangwenjun.futuretask.FutureService;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName OrderServiceImpl
 * @Description
 * @Author xsir
 * @Date 2021/10/10 上午7:11
 * @Version V1.0
 */
public class OrderServiceImpl implements OrderService {


    @ActiveMethod
    @Override
    public Future<String> findOrderDetails(long orderId) {
        return FutureService.<Long,String>newService().submit(input ->
        {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("process the orderID -> "+orderId);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "The order Details Information";
        },orderId);
    }

    @ActiveMethod
    @Override
    public void order(String account, long orderId) {
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("process the order for account "+account+", orderId "+orderId);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
