package com.atguigu.search;

import java.util.Arrays;

public class FibonacciSearch {

    public static void main(String[] args) {
//        int[] arr = {1,8, 10, 89, 1000, 1234};
        int[] arr = SearchHelp.genSortArr(1000000);
        int[] fibArr = fibArr();
        int findVal = arr[85435];

//        System.out.println(Arrays.toString(fibArr));

        int index = fibSearch1(arr, fibArr, findVal);
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
    public static int fibSearch2() {

        return -1;
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


















