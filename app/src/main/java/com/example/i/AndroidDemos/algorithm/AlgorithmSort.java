package com.example.i.AndroidDemos.algorithm;

/***
 * Created by I on 2017/9/7.
 */

public class AlgorithmSort {
    /***********************************冒泡排序************************************/
   public static int[] bubbleSort(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        int temp;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }

    public static int[] bubbleMySort(int[] data) {
        int temp;
        for (int i = 1; i < data.length; i++) {
            for (int m = 0; m < data.length - i; m++) {
                if (data[m] > data[m + 1]) {
                    temp = data[m];
                    data[m] = data[m + 1];
                    data[m + 1] = temp;
                }
            }
        }
        return data;
    }

    /***********************************选择排序************************************/
   public static int[] selectSort(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }

        for (int i = 0; i < data.length - 1; i++) {
            int min = i;// 将当前下标定为最小值下标
            for (int j = i + 1; j < data.length; j++) {//找到整个数组中的最小值下标
                if (data[j] < data[min]) {
                    min = j;
                }
            }

            if (i != min) {//只要找到的最小值下标跟事先规定的最小值下标不相等就交换
                int tmp = data[i];
                data[i] = data[min];
                data[min] = tmp;
            }
        }
        return data;
    }

    /***********************************快速排序************************************/
    public static int[] quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return null;

        if (low >= high)
            return arr;
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {//从头开始查找比中轴数字大的数字，一直查找，直到找到为止
                i++;
            }
            while (arr[j] > pivot) {//从末尾开始查找比中轴数字小的数字，一直查找，直到找到为止
                j--;
            }
            if (i <= j) {//只要这一轮找到的两个数字左边的比右边的小，就交换
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
        return arr;
    }

    /***********************************快速排序(递归实现)************************************/

}
