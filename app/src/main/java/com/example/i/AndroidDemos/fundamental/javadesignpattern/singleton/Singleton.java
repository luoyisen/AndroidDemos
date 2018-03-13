package com.example.i.AndroidDemos.fundamental.javadesignpattern.singleton;

import android.util.Log;

/***
 * Created by I on 2017/9/19.
 */

public class Singleton {
    /*
     * 懒汉式，线程不安全
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
    /*
     * 懒汉式，线程安全
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

    /*
     * 双重检验锁(DCL),并不完美
     * （3dpager1）.使用DCL能确保只生成单例，他的问题在于可能让其他线程看到这个单例的未构建完全的样子
     * （2）.DCL背后的理论是完美的，他失败的原因不是jvm的bug，而是java的内存模型导致的，关键原因在于：
     *  new操作不是原子的，而java内存模型允许指令重排。
     *
     *  为什么要判断2次不为空?这是因为如果没有volatile关键字,问题可能会出在singleton = new Singleton();
     *  这句,用伪代码表示
     *  (3dpager1). inst = allocat()；   // 分配内存
     *  (2). sSingleton = inst；  // 赋值
     *  (3). constructor(inst);； // 真正执行构造函数
     *  而正确的执行顺序则是:
     *  (3dpager1). mem= allocate();     //分配内存
     *  (2). callConstructor(mem);//调用构造函数
     *  (3). Instance=mem;        //把内存指针赋值给instance。
     *  可能会由于虚拟机的优化等导致赋值操作先执行,而构造函数还没完成,导致其他线程访问得到singleton变量不为null,但初始化还未完成,导致程序崩溃。
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

    /*
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

    /*
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
    /*
     * enum实现单利(完美方案)
     */

    public enum EasySingleton {
        INSTANCE;
        private int age;

        EasySingleton() {
            this.age = age;
        }

        public void showAge() {
            Log.i("singleton", age + "");
        }

//    public static final void main(String[] args) throws InterruptedException {
//        EasySingleton.INSTANCE.showAge();
//    }
    }
}
