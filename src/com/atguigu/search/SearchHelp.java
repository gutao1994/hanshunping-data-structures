package com.atguigu.search;

public class SearchHelp {

    public static int[] genUnSortArr(int amount) {
        int[] arr = new int[amount];

        for (int i = 0; i < amount; i++) {
            arr[i] = (int)(Math.random() * 100000000);
        }

        return arr;
    }

    public static int[] genSortArr(int amount) {
        int[] arr = new int[amount];
        arr[0] = 1;

        for (int i = 1; i < amount; i++) {
            arr[i] = arr[i - 1] + (int)(Math.random() * 1000);
        }

        return arr;
    }



}




















