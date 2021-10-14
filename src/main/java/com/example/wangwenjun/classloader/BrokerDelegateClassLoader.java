package com.example.wangwenjun.classloader;

import com.sun.org.apache.xml.internal.utils.NameSpace;

/**
 * @ClassName ①根据类的全路径名称进行加锁，确保每一个类在多线程的情况下只被加载一次。
 * ②到已加载类的缓存中查看该类是否已经被加载，如果已加载则直接返回。
 * ③④若缓存中没有被加载的类，则需要对其进行首次加载，如果类的全路径以java和javax开头，则直接委托给系统类加载器对其进行加载。
 * ⑤如果类不是以java和javax开头，则尝试用我们自定义的类加载进行加载。
 * ⑥若自定义类加载仍旧没有完成对类的加载，则委托给其父类加载器进行加载或者系统类加载器进行加载。
 * ⑦经过若干次的尝试之后，如果还是无法对类进行加载，则抛出无法找到类的异常。
 * @Description
 * @Author xsir
 * @Date 2021/9/22 上午6:28
 * @Version V1.0
 */
public class BrokerDelegateClassLoader extends MyClassLoader {
    @Override
    public Class<?> loadClass(String name,boolean resolve) throws ClassNotFoundException {

        // ①
        synchronized (getClassLoadingLock(name)){

            // ②
            Class<?> klass = findLoadedClass(name);

            // ③
            if (klass == null){
                // ④
                if (name.startsWith("java.") || name.startsWith("javax")){
                    try {
                        klass = getSystemClassLoader().loadClass(name);
                    }catch (Exception e){

                    }
                }else {
                    try {
                        // ⑤
                        klass = this.findClass(name);
                    }catch (ClassNotFoundException e){

                    }
                    //⑥
                    if (klass == null){
                        if (getParent() != null){
                            klass = getParent().loadClass(name);
                        }else {
                            klass = getSystemClassLoader().loadClass(name);
                        }
                    }
                }
            }
            // ⑦
            if (null == klass){
                throw new ClassNotFoundException("The class "+name+" not found.");
            }

            if (resolve){
                resolveClass(klass);
            }
            return klass;

        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = NameSpace.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("com.wangwenjun.concurrent.chapter10.Test");
        Class<?> bClass = classLoader.loadClass("com.wangwenjun.concurrent.chapter10.Test");
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        System.out.println(aClass == bClass);
    }

}
