package com.atguigu.search;

import java.util.Arrays;

public class InsertValueSearch {

    public static int total;

    public static void main(String[] args) {
        int arr[] = SearchHelp.genSortArr(10000000);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(arr[arr.length - 1]);
        int findVal = 10000;

        int index = insertValueSearch(arr, 0, arr.length - 1, findVal);
//        int index = insertValueSearchError(arr, 0, arr.length - 1, findVal);
        System.out.println("index = " + index);
    }

    public static int insertValueSearch(int[] arr, int left, int right, int val) {
        System.out.println("哈哈哈");

        if (left > right || val < arr[left] || val > arr[right]) {
            return -1;
        }

        if (arr[left] == arr[right]) {
            return left;
        }

        float rate = (float)(val - arr[left]) / (float)(arr[right] - arr[left]);
        int mid = left + (int)((right - left) * rate);
        int midVal = arr[mid];

        if (val < midVal) {
            return insertValueSearch(arr, left, mid - 1, val);
        } else if (val > midVal) {
            return insertValueSearch(arr, mid + 1, right, val);
        } else {
            return mid;
        }
    }

    public static int insertValueSearchError(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        if (findVal > midVal) {
            return insertValueSearchError(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValueSearchError(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }



}

















