package com.example.i.AndroidDemos.util;

import android.util.Log;

/***
 * Created by I on 2017/10/17.
 */

public class Syhchronizeds {

    /**
     * synchronized用来修饰非静态方法，而非静态方法又是类对象所有，所以在不同对象的writeSomething()方法互不干扰
     */
    public static class Synchronized1 extends Thread {
        @Override
        public void run() {
            printSth1();
        }

        synchronized void printSth1() {//非静态
            for (int i = 0; i < 10; i++) {
                Log.i("synchronized", i + " ");
            }
        }
    }

    /**
     * synchronized用来修饰静态方法
     */
    public static class Synchronized2 extends Thread {
        @Override
        public void run() {
            printSth2();
        }

        synchronized static void printSth2() {//静态
            for (int i = 0; i < 10; i++) {
                Log.i("synchronized", i + " ");
            }
        }
    }

    /**
     * synchronized
     */
    public static class Synchronized3 {
        synchronized void printSth3() {
            for (int i = 0; i < 10; i++) {
                Log.i("synchronized", i + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     */
    public static class Synchronized4 {
        synchronized void writeSomething() {
            for (int i = 0; i < 10; i++) {
                Log.i("synchronized", i + " ");
            }
        }

        synchronized void printSomething() {
            for (int i = 0; i < 10; i++) {
                Log.i("synchronized", i + " ");
            }
        }
    }


}
