package com.atguigu.sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = SortHelp.genArr(10000000);

        SortHelp.printBeforeTime();

        radixSort(arr);

        SortHelp.printAfterTime();

//        System.out.print(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        int maxLength = (maxValue + "").length();
        int temp = 0;
        int arrIndex = 0;
        int[][] buckets = new int[10][arr.length];
        int[] bucketIndex = new int[10];

        for (int i = 0, mod = 1; i < maxLength; i++, mod *= 10) {
            for (int j = 0; j < arr.length; j++) {
                temp = arr[j] / mod % 10;
                buckets[temp][bucketIndex[temp]] = arr[j];
                bucketIndex[temp]++;
            }

            arrIndex = 0;

            for (int k = 0; k < buckets.length; k++) {
                for (int l = 0; l < bucketIndex[k]; l++) {
                    arr[arrIndex++] = buckets[k][l];
                }

                bucketIndex[k] = 0;
            }
        }
    }



}







































