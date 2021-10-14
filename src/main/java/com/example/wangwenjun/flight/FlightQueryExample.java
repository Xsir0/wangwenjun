package com.example.wangwenjun.flight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName FlightQueryExample
 * @Description
 * @Author xsir
 * @Date 2021/9/14 上午7:01
 * @Version V1.0
 */
public class FlightQueryExample {

    private static List<String> flightCompany = Arrays.asList("CSA","CEA","HNA");

    public static void main(String[] args) {
        List<String> results = search("SH","BJ");
        System.out.println("=======result=======");
        results.forEach(System.out::println);
    }

    private static List<String> search(String original,String dest){
        final List<String> result = new ArrayList<>();

        // ② 创建查询航班信息的线程列表
        List<FlightQueryTask> tasks = flightCompany.stream().map(airline->createSearchTask(airline,original,dest)).collect(toList());

        // ③ 分别启动这几个线程
        tasks.forEach(FlightQueryTask::start);

        // ④ 分别调用每一个线程的 join 方法，阻塞当前线程
        tasks.forEach(t->{
            try {
                t.join();
            }catch (InterruptedException e){

            }
        });

        tasks.stream().map(FlightQuery::get).forEach(result::addAll);

        return result;

    }

    private static FlightQueryTask createSearchTask(String flight,String original,String dest){
        return new FlightQueryTask(flight,original,dest);
    }

}
