package com.atguigu.sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = SortHelp.genArr(200000);

        SortHelp.printBeforeTime();

        selectSort(arr);

        SortHelp.printAfterTime();

//        System.out.print(Arrays.toString(arr));
    }

    /**
     * 选择排序
     */
    public static void selectSort(int[] arr) {
        int minIndex = 0;
        int minValue = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            minValue = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minValue) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
    }

}




























