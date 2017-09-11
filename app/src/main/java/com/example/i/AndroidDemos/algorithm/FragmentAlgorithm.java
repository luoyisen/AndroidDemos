package com.example.i.AndroidDemos.algorithm;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.i.AndroidDemos.MyApplication;
import com.example.i.AndroidDemos.adapter.BaseRVAdapter;
import com.example.i.AndroidDemos.base.BaseFragmentWithRV;
import com.example.i.AndroidDemos.noteandtools.note.NoteDialogWithConfig;

import java.util.ArrayList;
import java.util.Random;

/***
 * Created by I on 2017/9/7.
 */

public class FragmentAlgorithm extends BaseFragmentWithRV {
    int[] data;
    Random random;
    Handler handler;
    StringBuilder stringBuilder;
    int randomnumber;
    boolean alreadyExpanded = false;
    ArrayList<String> arrayList;
    String[] stringList_SortAlgorithm = {
            "基数排序"
            , "桶排序"
            , "计数排序"
            , "归并排序"
            , "希尔排序"
            , "堆排序"
            , "插入排序"
            , "快速排序"
            , "选择排序"
            , "冒泡排序"
    };

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        data = new int[10];
        random = new Random();
        for (int i = 0; i < 10; i++) {
            data[i] = random.nextInt(10000000);
        }

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        stringBuilder = new StringBuilder();
                        for (int i = 0; i < 10; i++) {
                            stringBuilder.append((((int[]) msg.obj)[i] + "><"));//单线程用stringbuilder
                        }
                        new NoteDialogWithConfig
                                .Builder(MyApplication.getContext())
                                .setTitle("一万个随机数排序用时:" + msg.getData().getInt("usedtime") + "ms")
                                .setMessage(stringBuilder.toString())
                                .setCancelAble(true)
                                .create()
                                .show();
                        break;
                    case 1:
                        stringBuilder = new StringBuilder();
                        for (int i = 0; i < 10; i++) {
                            stringBuilder.append((((int[]) msg.obj)[i] + "><"));//单线程用stringbuilder
                        }
                        new NoteDialogWithConfig.Builder(MyApplication.getContext())
                                .setTitle("一万个随机数排序用时:" + msg.getData().getInt("usedtime") + "ms")
                                .setMessage(stringBuilder.toString())
                                .setCancelAble(true)
                                .create()
                                .show();
                        break;
                    case 2:
                        stringBuilder = new StringBuilder();
                        for (int i = 0; i < 10; i++) {
                            stringBuilder.append((((int[]) msg.obj)[i] + "><"));//单线程用stringbuilder
                        }
                        new NoteDialogWithConfig.Builder(MyApplication.getContext())
                                .setTitle("一万个随机数排序用时:" + msg.getData().getInt("usedtime") + "ms")
                                .setMessage(stringBuilder.toString())
                                .setCancelAble(true)
                                .create()
                                .show();
                        break;
                }
            }
        };
        arrayList = new ArrayList<>();
        arrayList.add("********** 排序算法 **********");
        arrayList.add("********** 反转数字 **********");
        arrayList.add("********** 二分查找 **********");
        arrayList.add("********* 欧几里得算法 *********");
        arrayList.add("********** 二分算法 **********");
        adapter = new BaseRVAdapter(arrayList, getActivity().getClass().getSimpleName());
        rv_base_fragment.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        if (alreadyExpanded) {
                            removeSortAlgorithItems();
                        } else {
                            addSortAlgorithmItems();
                        }
                        break;
                    case 1:
                        if (alreadyExpanded)
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    long begintime = System.currentTimeMillis();
                                    AlgorithmSort.bubbleMySort(data);
                                    long usedtime = System.currentTimeMillis() - begintime;
                                    Message msg0 = new Message();
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("usedtime", (int) usedtime);
                                    msg0.setData(bundle);
                                    msg0.obj = data;
                                    msg0.what = 0;
                                    handler.sendMessage(msg0);
                                }
                            }).start();
                        else {
                            randomnumber = random.nextInt(100000000);
                            Toast.makeText(getActivity(), "随机数:" + randomnumber + "反转以后是:" + AlgorithmNumber.reverseNumber(randomnumber), Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 2:
                        if (alreadyExpanded)
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    long begintime = System.currentTimeMillis();
                                    AlgorithmSort.selectSort(data);
                                    long usedtime = System.currentTimeMillis() - begintime;
                                    Message msg1 = new Message();//同时用obj和bundle传递数据
                                    msg1.obj = data;
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("usedtime", (int) usedtime);
                                    msg1.setData(bundle);
                                    msg1.what = 1;
                                    handler.sendMessage(msg1);
                                }
                            }).start();
                        else
                            Toast.makeText(getActivity(), "5在数组中的下标是:" + AlgorithmNumber.binarySearch1(data, 0, data.length - 1, 5), Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        if (alreadyExpanded) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    long begintime = System.currentTimeMillis();
                                    AlgorithmSort.quickSort(data, 0, data.length - 1);
                                    long usedtime = System.currentTimeMillis() - begintime;
                                    Message msg2 = new Message();
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("usedtime", (int) usedtime);
                                    msg2.obj = data;
                                    msg2.what = 2;
                                    msg2.setData(bundle);
                                    handler.sendMessage(msg2);
                                }
                            }).start();
                        } else
                            Toast.makeText(getActivity(), "欧几里得算法:596和232的最大公约数是:" + AlgorithmNumber.gcd(596, 232) + "", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        if (alreadyExpanded) {
                            Toast.makeText(getActivity(), "do it", Toast.LENGTH_SHORT).show();
                        } else

                            break;
                    case 5:
                        if (alreadyExpanded)
                            Toast.makeText(getActivity(), "do it", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(), "do my own thing", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        if (alreadyExpanded)
                            Toast.makeText(getActivity(), "do it", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(), "do my own thing", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        if (alreadyExpanded)
                            Toast.makeText(getActivity(), "do it", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(), "do my own thing", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        if (alreadyExpanded)
                            Toast.makeText(getActivity(), "do it", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(), "do my own thing", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        if (alreadyExpanded)
                            Toast.makeText(getActivity(), "do it", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(), "do my own thing", Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        if (alreadyExpanded)
                            Toast.makeText(getActivity(), "do it", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(), "do my own thing", Toast.LENGTH_SHORT).show();
                        break;
                    case 11:
                        if (alreadyExpanded) {
                            removeSortAlgorithItems();
                            randomnumber = random.nextInt(100000000);
                            Toast.makeText(getActivity(), "随机数:" + randomnumber + "反转以后是:" + AlgorithmNumber.reverseNumber(randomnumber), Toast.LENGTH_LONG).show();
                        } else
                            Toast.makeText(getActivity(), "do my own thing", Toast.LENGTH_SHORT).show();
                        break;
                    case 12:
                        if (alreadyExpanded)
                            removeSortAlgorithItems();
                        else
                            Toast.makeText(getActivity(), "do my own thing", Toast.LENGTH_SHORT).show();
                        break;
                    case 13:
                        if (alreadyExpanded)
                            removeSortAlgorithItems();
                        else
                            Toast.makeText(getActivity(), "do my own thing", Toast.LENGTH_SHORT).show();
                        break;
                    case 14:
                        if (alreadyExpanded)
                            removeSortAlgorithItems();
                        else
                            Toast.makeText(getActivity(), "do my own thing", Toast.LENGTH_SHORT).show();
                        break;
                    case 15:
                        if (alreadyExpanded)
                            removeSortAlgorithItems();
                        else
                            Toast.makeText(getActivity(), "do my own thing", Toast.LENGTH_SHORT).show();
                        break;

                }
            }

            @Override
            public void onItemLongClick(View view, int pisition) {
            }
        });
    }

    public void addSortAlgorithmItems() {
        for (String aStringList_SortAlgorithm : stringList_SortAlgorithm) {
            arrayList.add(1, aStringList_SortAlgorithm);
            adapter.notifyItemInserted(1);
        }
        rv_base_fragment.scrollToPosition(0);
        alreadyExpanded = true;
    }

    public void removeSortAlgorithItems() {
        int i = 0;
        if (arrayList.size() >= 10) {
            while (i < 10) {
                arrayList.remove(1);
                adapter.notifyItemRemoved(1);
                i++;
            }
            alreadyExpanded = false;
        }
    }
}
