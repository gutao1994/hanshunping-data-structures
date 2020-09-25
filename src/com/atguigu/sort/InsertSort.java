package com.atguigu.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = SortHelp.genArr(200000);

        SortHelp.printBeforeTime();

        insertSort(arr);

        SortHelp.printAfterTime();

//        System.out.print(Arrays.toString(arr));
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] arr) {
        int loopValue = 0;
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            loopValue = arr[i];
            insertIndex = i - 1;

            while (insertIndex >= 0 && loopValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = loopValue;
            }
        }
    }

}


























































