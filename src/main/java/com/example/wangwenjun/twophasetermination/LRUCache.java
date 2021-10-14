package com.example.wangwenjun.twophasetermination;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName LRUCache
 * @Description
 * @Author xsir
 * @Date 2021/9/29 上午6:30
 * @Version V1.0
 */
public class LRUCache<K,V> {

    private final LinkedList<K> keyList = new LinkedList<>();

    private final Map<K,V> cache = new HashMap<>();

    // cache 最大容量
    private final int capacity;

    private final CacheLoader<K,V> cacheLoader;

    public LRUCache(int capacity,CacheLoader<K,V> cacheLoader){
        this.capacity = capacity;
        this.cacheLoader = cacheLoader;
    }

    public void put(K key,V value){
        // 当元素数量超过容量时，将最老的数据清除
        if (keyList.size()>=capacity){
            K eldestKey = keyList.removeFirst();// eldest data
        }

        if (keyList.contains(key)){
            keyList.remove(key);
        }

        keyList.addLast(key);
        cache.put(key,value);
    }

    public V get(K key){
        V value;

        boolean success = keyList.remove(key);

        if (!success){
            value = cacheLoader.load(key);
            this.put(key,value);
        }else {
            value = cache.get(key);
            keyList.addLast(key);
        }
        return value;
    }

    @Override
    public String toString(){
        return this.keyList.toString();
    }

}
