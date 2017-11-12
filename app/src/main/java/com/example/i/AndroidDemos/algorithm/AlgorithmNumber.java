package com.example.i.AndroidDemos.algorithm;

/***
 * Created by I on 2017/9/8.
 */

class AlgorithmNumber {
    //==============================反转数字==============================
    static int reverseNumber(int number) {
        int result = 0;
        while (number != 0) {
            result = result * 10 + number % 10;
            number = number / 10;
        }
        return result;
    }

    //====================欧几里得算法(求两个数的最大公约数)================
    static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    //==============================二分查找(递归实现)==============================
    public static int binarySearch1(int[] a, int fromIndex, int toIndex, int value) {
        if (fromIndex > toIndex)
            return -1;
        int mid = (fromIndex + toIndex) >>> 1;
        if (a[mid] < value) {
            return binarySearch1(a, mid + 1, toIndex, value);
        } else if (a[mid] > value) {
            return binarySearch1(a, fromIndex, mid - 1, value);
        } else {
            return mid;
        }
    }

    //==============================二分查找(非递归实现)==============================
    public static int binarySearch2(int[] a, int fromIndex, int toIndex, int value) {
        int low = fromIndex;
        int high = toIndex;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = a[mid];
            if (value > midVal)
                low = mid + 1;
            else if (value < midVal)
                high = mid - 1;
            else return mid;
        }
        return -1;
    }

    //==============================找出两个已经排好序的数组之间的重复值==============================
    public static int[] findSameBetweenTwoSortedArray(int[] x, int[] y) {
        int a = x.length, b = y.length;
        if (x[0] > y[b - 1] || y[0] > x[a - 1]) return null;
        if (x[0] == y[b - 1]) return new int[]{x[0]};
        if (x[a - 1] == y[0]) return new int[]{x[a - 1]};
        return null;
    }

}
