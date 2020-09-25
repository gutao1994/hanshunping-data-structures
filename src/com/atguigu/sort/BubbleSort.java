package com.atguigu.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = SortHelp.genArr(100000);

        SortHelp.printBeforeTime();

        bubbleSort(arr);

        SortHelp.printAfterTime();

//        System.out.print(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean isExChange = false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    isExChange = true;
                }
            }

            if (!isExChange) { //未发生交换
                break;
            } else {
                isExChange = false;
            }
        }
    }



}
























