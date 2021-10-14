package com.example.wangwenjun.eventbus;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName Registry
 * @Description
 * @Author xsir
 * @Date 2021/10/11 上午8:24
 * @Version V1.0
 */
public class Registry {

    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<Subscriber>> subscriberContainer = new ConcurrentHashMap<>();

    public void bind(Object subscriber){
        List<Method> subscribeMethods = getSubscribeMethods(subscriber);
        subscribeMethods.forEach(m->tierSubscriber(subscriber,m));
    }

    public void unbind(Object subscriber){
        subscriberContainer.forEach((key,queue)->queue.forEach(s->{
            if (s.getSubscribeObject() == subscriber){
                s.setDisable(true);
            }
        }));
    }

    public ConcurrentLinkedQueue<Subscriber> scanSubscriber(final String topic){
        return subscriberContainer.get(topic);
    }

    private void tierSubscriber(Object subscriber,Method method){
        final Subscribe subscribe = method.getDeclaredAnnotation(Subscribe.class);
        String topic = subscribe.topic();
        subscriberContainer.computeIfAbsent(topic,key->new ConcurrentLinkedQueue<>());
        subscriberContainer.get(topic).add(new Subscriber(subscriber,method));
    }

    private List<Method> getSubscribeMethods(Object subscriber){
        final List<Method> methods = new ArrayList<>();
        Class<?> temp = subscriber.getClass();

        while (temp != null){
            Method[] declaredMethods = temp.getDeclaredMethods();

            Arrays.stream(declaredMethods).filter(m->m.isAnnotationPresent(Subscribe.class)&& m.getParameterCount() ==1 && m.getModifiers() == Modifier.PUBLIC)
                    .forEach(methods::add);
            temp = temp.getSuperclass();
        }
        return methods;
    }

}
