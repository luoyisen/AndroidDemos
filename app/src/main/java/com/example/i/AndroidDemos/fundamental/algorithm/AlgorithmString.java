package com.example.i.AndroidDemos.fundamental.algorithm;

/***
 * Created by I on 2017/9/12.
 */

public class AlgorithmString {

    public static char[] putIntoArray(String word) {
        char[] chars = new char[word.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = word.charAt(i);
        }
        return chars;
    }

    public static String reverseWord(String s) {
        int i = 0;
        int j = s.length() - 1;
        char temp;
        StringBuilder builder = new StringBuilder();
        char[] chars = putIntoArray(s);
        while (i < j) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        for (char s1 : chars) {
            builder.append(s1);
        }
        return builder.toString();
    }

    public static String reverseSentence(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (String s1 : words) {
            builder.append(reverseWord(s1)).append(" ");
        }
        return builder.toString();
    }

}
