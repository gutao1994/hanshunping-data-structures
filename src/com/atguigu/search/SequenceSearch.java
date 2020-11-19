package com.atguigu.search;

import com.atguigu.sort.SortHelp;
import java.util.Arrays;

public class SequenceSearch {

    public static void main(String[] args) {
        int num = 300000000;
        int arr[] = SearchHelp.genUnSortArr(num); // 没有顺序的数组
//        System.out.println(Arrays.toString(arr));

        SortHelp.printBeforeTime();
        int index = seqSearch(arr, arr[num - 1]);
        SortHelp.printAfterTime();

        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到，下标为=" + index);
        }
    }

    public static int seqSearch(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return  i;
            }
        }
        return -1;
    }



}













































