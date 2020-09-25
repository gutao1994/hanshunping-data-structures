package com.atguigu.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = SortHelp.genArr(10000000);

        SortHelp.printBeforeTime();

        quickSort(arr, 0, arr.length - 1);

        SortHelp.printAfterTime();

//        System.out.print(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2]; //基准值
        int temp = 0;

        while (l < r) {
            while (arr[l] < pivot) { //找大于等于pivot的值
                l++;
            }

            while (arr[r] > pivot) { //找小于等于pivot的值
                r--;
            }

            if (l == r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r--;
            }

            if (arr[r] == pivot) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        if (left < r) { //向左递归
            quickSort(arr, left, r);
        }

        if (right > l) { //向右递归
            quickSort(arr, l, right);
        }
    }



}



























