package com.example.i.AndroidDemos.JAVA_BASE;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.android_architecture.JAVA_DESIGNPATTERN.EasySingleton;

/***
 * Created by I on 2017/10/17.
 */

public class ActivityJavaBase extends AppCompatActivity {
//    http://www.jianshu.com/p/20abba522545
    /**
     * 静态的类
     */
    static Syhchronizeds.Synchronized3 synchronized1 = new Syhchronizeds.Synchronized3();
    static Syhchronizeds.Synchronized4 synchronized2 = new Syhchronizeds.Synchronized4();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_base);
        /*
         * synchronized用来修饰非静态方法，而非静态方法又是类对象所有，所以在不同对象的writeSth()方法互不干扰
         */
//        Syhchronizeds.Synchronized1 synchronized1 = new Syhchronizeds.Synchronized1();
//        Syhchronizeds.Synchronized1 synchronized2 = new Syhchronizeds.Synchronized1();
//        synchronized1.start();
//        synchronized2.start();
        /*
         * synchronized用来修饰静态方法，而非静态方法不是类对象所有，所以在不同对象的writeSomething()方法互不干扰
         */
//        Syhchronizeds.Synchronized2 synchronized1 = new Syhchronizeds.Synchronized2();
//        Syhchronizeds.Synchronized2 synchronized2 = new Syhchronizeds.Synchronized2();
//        synchronized1.start();
//        synchronized2.start();
        /*
         * 第三种
         */
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized1.printSth3();
//            }
//        }).start();
//        synchronized1.printSth3();
        /*
         * 每一个对象只有一锁与之对应，当执行synchronized2.printSomething()时相当于当前线程拿到了synchronized2的锁，
         * 而其他线程只有等待它释放锁才能继续执行。而后面的synchronized2.writeSomething()方法继续执行正需要这个锁。
         * 所以它就必须等到前面synchronized2.printSomething()执行完，释放了锁以后拿到锁才能继续执行，所以就有了这样的输出结果。
         * 当一个线程访问object的一个synchronized同步方法时，其他线程对object中所有其它synchronized同步方法的的访问将被阻塞。
         */

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized2.printSomething();
//            }
//        }).start();
//        synchronized2.writeSomething();
        /*
         * 修饰静态方法没什么好解释的，因为静态方法不属于类对象，它是属于类的，所以如果用synchronized修饰静态方法，
         * 那么它在所有类对象中都是同步的。
         */

        /*
         * 我们在用synchronized关键字的时候，能缩小代码段的范围就尽量缩小，能在代码段上加同步就不要再整个方法上加同步。
         * 这叫减小锁的粒度，使代码更大程度的并发。因为当方法体过于庞大而需要同步的部分又很少，锁的时间就加长了，
         * 别的线程是不是要等很久。所以往往同步代码块比同步方法好用。synchronized代码块又分为这么几种:
         * synchronized（this），synchronized（className.class）和synchronized（Object obj）。
         */

        /*
         * synchronized(this)
         * synchronized(this)类似于前面的synchronized修饰非静态方法，锁都在当前对象，只限制当前对象对该代码块的同步。
         */
        writeSomething();

        /*
         * synchronized（className.class）
         * synchronized（className.class）类似于前面的synchronized修饰静态方法，锁在类而不在类对象，
         * 只要是className类对象访问该代码块都被要求同步。
         */

        /*
         * synchronized（Object obj）
         * 这时锁就是对象，谁拿到这个锁谁就可以运行它所控制的那段代码。当有一个明确的对象作为锁时，就可以这样写程序，
         * 但当没有明确的对象作为锁，只是想让一段代码同步时，可以创建一个特殊的instance变量（它得是一个对象）来充当锁:
         * tips：用的比较多的就是零长度的byte数组对象，创建起来将比任何对象都经济。查看编译后的字节码：
         * 生成零长度的byte[]对象只需3条操作码，而Object lock = new Object()则需要7行操作码。）
         * 这里的锁的作用范围取决于lock的作用域，谁能拿到这个lock就能访问该代码块。比如将lock作为staic全局变量就是类所有，
         * 这时synchronized (lock)就相当于synchronized (className.class)；相反，将lock作为局部变量（放在方法内）
         * 该synchronized 将失效，因为每个访问该方法的都能获得一个lock对象。
         */

        /*
         * volatile的使用场景，通过关键字sychronize可以防止多个线程进入同一段代码，在某些特定场景中，volatile相当于一个
         * 轻量级的sychronize，因为不会引起线程的上下文切换，一旦一个共享变量（类的成员变量、类的静态成员变量）
         * 被volatile修饰之后，那么就具备了两层语义：
         * (1).保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
         * volatile关键字会强制将修改的值立即写入主存，使线程的工作内存中缓存变量行无效。
         * (2).禁止进行指令重排序。
         * 在java虚拟机的内存模型中，有主内存和工作内存的概念，每个线程对应一个工作内存，并共享主内存的数据。
         * 对于普通变量：读操作会优先读取工作内存的数据，如果工作内存中不存在，则从主内存中拷贝一份数据到工作内存中；
         * 写操作只会修改工作内存的副本数据，这种情况下，其它线程就无法读取变量的最新值。
         * 对于volatile变量，读操作时JMM会把工作内存中对应的值设为无效，要求线程从主内存中读取数据；
         * 写操作时JMM会把工作内存中对应的数据刷新到主内存中，这种情况下，其它线程就可以读取变量的最新值。
         * volatile关键字在双重锁的单例模式中
         */
//        public class Singleton {
//
//            private volatile static Singleton instance;
//
//            private Singleton() {
//            }
//
//            public static Singleton getSingleton() {
//                if (instance == null) {
//                    synchronized (Singleton.class) {
//                        if (instance == null) {
//                            instance = new Singleton();
//                        }
//                    }
//                }
//                return instance;
//            }
//        }
//        为什么要判断2次不为空?这是因为如果没有volatile关键字,问题可能会出在singleton = new Singleton();这句,用伪代码表示
//
//        (1). inst = allocat()；   // 分配内存
//        (2). sSingleton = inst；  // 赋值
//        (3). constructor(inst);； // 真正执行构造函数
//        而正确的执行顺序则是:
//        (1). mem= allocate();     //分配内存
//        (2). callConstructor(mem);//调用构造函数
//        (3). Instance=mem;        //把内存指针赋值给instance。
//        可能会由于虚拟机的优化等导致赋值操作先执行,而构造函数还没完成,导致其他线程访问得到singleton变量不为null,但初始化还未完成,导致程序崩溃。

        EasySingleton.INSTANCE.showAge();
    }


    public synchronized void writeSomething() {
        //其他代码
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                Log.i("synchronized", i + " ");
            }
        }
        //其他代码
    }


    class Test {
        public synchronized void writeSomething() {
            //其他代码
            synchronized (Test.class) {
                for (int i = 0; i < 10; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            //其他代码
        }
    }


//    class Test1 {
//        private static byte[] lock = new byte[0]; // 特殊的instance变量 public
//
//        synchronized void writeSomething() {
//            //其他代码
//            synchronized (lock) {
//                for (int i = 0; i < 10; i++) {
//                    System.out.print(i + " ");
//                }
//                System.out.println();
//            }
//            //其他代码
//        }
//    }

}
