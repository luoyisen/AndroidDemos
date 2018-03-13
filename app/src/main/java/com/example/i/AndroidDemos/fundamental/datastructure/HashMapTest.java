package com.example.i.AndroidDemos.fundamental.datastructure;

import com.example.i.AndroidDemos.constant.bean.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by HHX on 2018/3/13.
 */

public class HashMapTest {
    /**
     * 已知一个HashMap<Integer,User>集合，User有name(String)和age(int)属性，请写一个方法实现对HashMap的排序，
     * 该方法接收HashMap<Integer,User>为形参，返回类型为HashMap<Integer,User>。
     * 要求对HashMap中的User的age进行倒序排序，排序时key-value键值对不可拆散
     */
    //-----------------------------HashMap<Integer,User>排序题--------------------------------
    public static HashMap<Integer, User> sortUserByAge(HashMap<Integer, User> hashMap) {
        Set<Map.Entry<Integer, User>> entrySet = hashMap.entrySet();
        List<Map.Entry<Integer, User>> list = new ArrayList<Map.Entry<Integer, User>>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });

        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }


}
