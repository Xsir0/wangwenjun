package com.example.wangwenjun.activeobject;

import com.example.wangwenjun.futuretask.Future;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ActiveServiceFactory
 * @Description
 * @Author xsir
 * @Date 2021/10/10 上午6:44
 * @Version V1.0
 */
public class ActiveServiceFactory {

    private final static ActiveMessageQueue queue = new ActiveMessageQueue();

    private static <T> T active(T instance){
        return (T) Proxy.newProxyInstance(instance.getClass().getClassLoader(),instance.getClass().getInterfaces(),new ActiveInvocationHandler<>(instance));
    }

    private static class ActiveInvocationHandler<T> implements InvocationHandler{
        private final T instance;

        ActiveInvocationHandler(T instance){
            this.instance = instance;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.isAnnotationPresent(ActiveMethod.class)){
                // 检查该方法是否规范
                this.checkMethod(method);
                ActiveMessage.Builder builder = new ActiveMessage.Builder();
                builder.useMethod(method).withObjects(args).forService(instance);
                Object result = null;
                if (this.isReturnFutureType(method)){
                    result = new ActiveFuture<>();
                    builder.returnFuture((ActiveFuture<Object>) result);
                }
                // 将 ActiveMessage 加入到队列
                queue.offer(builder.build());
                return result;
            }else {
                // 如果是普通方法，则会正常执行
                return method.invoke(instance,args);
            }
        }

        private void checkMethod(Method method) throws IllegalActiveMethod{
            if (!isReturnVoidType(method) && !isReturnFutureType(method)){
                throw new IllegalActiveMethod("the method ["+method.getName()+" return type must be void/Future");
            }
        }

        private boolean isReturnFutureType(Method method){
            return method.getReturnType().isAssignableFrom(Future.class);
        }

        private boolean isReturnVoidType(Method method){
            return method.getReturnType().equals(Void.TYPE);
        }

    }


    public static class ActiveDaemonThread extends Thread {

        private ActiveMessageQueue queue;

        public ActiveDaemonThread(ActiveMessageQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for(;;){
                ActiveMessage activeMessage = this.queue.take();
                activeMessage.execute();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        OrderService orderService = active(new OrderServiceImpl());
        Future<String> future = orderService.findOrderDetails(23333);

        System.out.println(future.get());
        System.out.println(future.get());
    }

}
