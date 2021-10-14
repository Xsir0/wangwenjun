package com.example.wangwenjun.twophasetermination;

@FunctionalInterface
public interface CacheLoader<K,V> {

    V load(K k);

}
