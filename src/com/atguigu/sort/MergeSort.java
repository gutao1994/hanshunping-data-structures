package com.atguigu.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = SortHelp.genArr(10000000);

//        int[] arr = {1, 1, 1, 1, 1};

        SortHelp.printBeforeTime();

        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);

        SortHelp.printAfterTime();

//        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;

            //向左递归分解
            mergeSort(arr, left, mid, temp);

            //向左递归分解
            mergeSort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int leftStartIndex = left;
        int rightStartIndex = mid + 1;
        int tempIndex = 0;

        while (leftStartIndex <= mid && rightStartIndex <= right) {
            if (arr[leftStartIndex] <= arr[rightStartIndex]) {
                temp[tempIndex] = arr[leftStartIndex];
                leftStartIndex++;
            } else {
                temp[tempIndex] = arr[rightStartIndex];
                rightStartIndex++;
            }

            tempIndex++;
        }

        while (leftStartIndex <= mid) {
            temp[tempIndex] = arr[leftStartIndex];
            leftStartIndex++;
            tempIndex++;
        }

        while (rightStartIndex <= right) {
            temp[tempIndex] = arr[rightStartIndex];
            rightStartIndex++;
            tempIndex++;
        }

        tempIndex = 0;
        while (left <= right) {
            arr[left] = temp[tempIndex];
            left++;
            tempIndex++;
        }
    }



}








































