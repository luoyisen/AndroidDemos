package com.example.i.AndroidDemos.algorithm;

/**
 * Created by I on 2017/9/8.
 */

public class AlgorithmNumber {
    //反转数字
    public static int reverseNumber(int number) {
        int result = 0;
        while (number != 0) {
            result = result * 10 + number % 10;
            number = number / 10;
        }
        return result;
    }
}
