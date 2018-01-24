package com.example.i.AndroidDemos.util;

import android.util.Log;

/***
 * Created by I on 2017/10/21.
 */

public class AutoboxingTest {

    public static void test() {

        // Example 3dpager1: == comparison pure primitive – no autoboxing
        int i1 = 1;
        int i2 = 1;
        Log.i("自动装箱与拆箱", String.valueOf((i1 == i2)));//true

        // Example 2: equality operator mixing object and primitive
        Integer num1 = 1; // autoboxing
        int num2 = 1;
        Log.i("自动装箱与拆箱", String.valueOf((num1 == num2)));//true

        // Example 3: special case - arises due to autoboxing in Java
        /*
         * obj1和obj2的初始化都发生了自动装箱操作。但是处于节省内存的考虑，
         * JVM会缓存-128到127的Integer对象。因为obj1和obj2实际上是同一个对象。
         * 所以使用”==“比较返回true。
         * 而如果不在此范围内的话，则为false，如下两例:
         */
        // cached Object
        Integer obj1 = 1; // autoboxing will call Integer.valueOf()
        Integer obj2 = 1; // same call to Integer.valueOf() will return same
        // not cached Object
        Integer obj3 = 155;
        Integer obj4 = 155;

        Log.i("自动装箱与拆箱", String.valueOf((obj1 == obj2)));//true
        Log.i("自动装箱与拆箱", String.valueOf((obj3 == obj4)));//false

        // Example 4: equality operator - pure object comparison
        Integer one = new Integer(1); // no autoboxing
        Integer anotherOne = new Integer(1);
        Log.i("自动装箱与拆箱", String.valueOf((one == anotherOne)));//false

    }

}
