package com.atguigu.search;

import java.util.Arrays;

public class FibonacciSearch {

    public static void main(String[] args) {
//        int[] arr = {1,8, 10, 89, 1000, 1234};
        int[] arr = SearchHelp.genSortArr(1000000);
        int[] fibArr = fibArr();
        int findVal = arr[1000000 - 1];

//        System.out.println(Arrays.toString(fibArr));

        int index = fibSearch2(arr, fibArr, findVal);
        System.out.println("index = " + index);
    }

    /**
     * 非递归方式
     */
    public static int fibSearch1(int[] arr, int[] fibArr, int val) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        int midVal = 0;
        int k = 0;

        while (arr.length > fibArr[k] - 1) {
            k++;
        }

        int[] tempArr = Arrays.copyOf(arr, fibArr[k] - 1);

        for (int i = arr.length; i < tempArr.length; i++) {
            tempArr[i] = arr[arr.length - 1];
        }
        int tempRight = tempArr.length - 1;

        while (left <= tempRight) {
            mid = left + fibArr[k - 1] - 1;
            midVal = tempArr[mid];

            if (val < midVal) {
                tempRight = mid - 1;
                k -= 1;
            } else if (val > midVal) {
                left = mid + 1;
                k -= 2;
            } else {
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }
            }
        }

        return -1;
    }

    /**
     * 递归方式
     */
    public static int fibSearch2(int[] arr, int[] fibArr, int val) {
        int k = 0;

        while (arr.length > fibArr[k] - 1) {
            k++;
        }

        int[] tempArr = Arrays.copyOf(arr, fibArr[k] - 1);

        for (int i = arr.length; i < tempArr.length; i++) {
            tempArr[i] = arr[arr.length - 1];
        }

        int index = fibSearch2Run(tempArr, fibArr, k, 0, tempArr.length - 1, val);

        return Math.min(index, arr.length - 1);
    }

    private static int fibSearch2Run(int[] arr, int[] fibArr, int k, int left, int right, int val) {
        System.out.println("哈哈哈");

        if (left > right) {
            return -1;
        }

        int mid = left + fibArr[k - 1] - 1;
        int midVal = arr[mid];

        if (val < midVal) {
            return fibSearch2Run(arr, fibArr, k - 1, left, mid - 1, val);
        } else if (val > midVal) {
            return  fibSearch2Run(arr, fibArr, k - 2, mid + 1, right, val);
        } else {
            return mid;
        }
    }

    /**
     * 生成斐波那契数列
     */
    public static int[] fibArr() {
        int[] arr = new int[40];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < 40; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr;
    }



}


















