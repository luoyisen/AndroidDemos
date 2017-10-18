package com.example.i.AndroidDemos.android_architecture.JAVA_DESIGNPATTERN;

/***
 * Created by I on 2017/9/19.
 */

public class Singleton {
    /***
     * 懒汉式，线程不安全
     *
     * 使用了懒加载模式，但是却存在致命的问题。当有多个线程并行调用 getInstance() 的时候，就会创建多个实例。也就是说在多线程下不能正常工作。
     */
//    private Singleton() {
//    }
//
//    private static Singleton instance;
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            return new Singleton();
//        }
//        return instance;
//    }
    /***
     * 懒汉式，线程安全
     *
     * 虽然做到了线程安全，并且解决了多实例的问题，但是它并不高效。因为在任何时候只能有一个线程调用 getInstance() 方法。但是同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时。这就引出了双重检验锁。
     */
//    private Singleton() {
//    }
//
//    private static Singleton instance;
//
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            return new Singleton();
//        }
//        return instance;
//    }

    /***
     * 双重检验锁k
     */

//    private volatile static Singleton instance; //声明成 volatile
//
//    private Singleton() {
//    }
//
//    public static Singleton getSingleton() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    /***
     * 饿汉式 static final field
     *
     * 类加载时就初始化
     */

//    private static final Singleton instance = new Singleton();
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        return instance;
//    }

    /***
     *  静态内部类 static nested class
     *
     * 由于 SingletonHolder 是私有的，除了 getInstance() 之外没有办法访问它，因此它是懒汉式的；同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本。
     */

//    private static class SingletonHolder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    private Singleton() {
//    }
//
//    public static  Singleton getInstance() {
//        return SingletonHolder.INSTANCE;
//    }

    /***
     * 枚举
     */
    public enum EasySingleton{
        INSTANCE;
    }


}
