package com.atguigu.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr1 = SortHelp.genArr(100000000);
        int[] arr2 = SortHelp.genArr(100000000);

        SortHelp.printBeforeTime();

        shellSortByExchange(arr1);

        SortHelp.printAfterTime();

        SortHelp.printBeforeTime();

        shellSortByMove(arr2);

        SortHelp.printAfterTime();

//        System.out.print(Arrays.toString(arr2));
    }

    /**
     * 希尔排序 - 交换法
     */
    public static void shellSortByExchange(int[] arr) {
        int temp = 0;

        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j + gap] < arr[j]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序 - 移位法
     */
    public static void shellSortByMove(int[] arr) {
        int loopValue = 0;
        int insertIndex = 0;

        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                loopValue = arr[i];
                insertIndex = i - gap;

                if (loopValue < arr[insertIndex]) {
                    while (insertIndex >= 0 && loopValue < arr[insertIndex]) {
                        arr[insertIndex + gap] = arr[insertIndex];
                        insertIndex -= gap;
                    }
                    arr[insertIndex + gap] = loopValue;
                }
            }
        }
    }

}














































