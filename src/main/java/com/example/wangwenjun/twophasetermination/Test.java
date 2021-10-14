package com.example.wangwenjun.twophasetermination;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.sql.Ref;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @ClassName Test
 * @Description
 * @Author xsir
 * @Date 2021/9/29 上午6:44
 * @Version V1.0
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {


        LRUCache<String,Reference> cache = new LRUCache<>(5,key->new Reference());
        // SoftLRUCache<String,Reference> cache = new SoftLRUCache<>(1000,key->new Reference());

        System.out.println(cache);


        cache.get("ALEX");
        cache.get("JACK");
        cache.get("GAVIN");
        cache.get("DILLON");
        cache.get("LEO");

        // ALEX 将会被剔除
        cache.get("JENNY");

        // IntStream.range(i,Integer.MAX_VALUE).forEach(i->cache.get(String.valueOf(i)));

        System.out.println(cache.toString());

        // ReferenceQueue<Reference> queue = new ReferenceQueue<>();
        //
        // Reference ref = new Reference();
        //
        // WeakReference<Reference> referenceWeakReference = new WeakReference<>(ref,queue);
        //
        // ref = null;
        // System.out.println("rrr : "+referenceWeakReference.get());
        //
        // System.gc();
        // TimeUnit.SECONDS.sleep(1);
        //
        // java.lang.ref.Reference<? extends Reference> gcedRef = queue.remove();
        //
        // System.out.println(gcedRef);


        ReferenceQueue<Reference> queue = new ReferenceQueue<>();
        PhantomReference<Reference> reference = new PhantomReference<>(new Reference(),queue);
        System.out.println(reference.get()); // 始终返回null
        System.gc();
        java.lang.ref.Reference<? extends Reference> gcedRef = queue.remove();
        System.out.println(gcedRef);


    }

}
