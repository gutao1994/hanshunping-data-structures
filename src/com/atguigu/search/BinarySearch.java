package com.atguigu.search;

import com.atguigu.sort.SortHelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int num = 1000000;
        int arr[] = SearchHelp.genSortArr(num);
//        System.out.println(Arrays.toString(arr));

//        SortHelp.printBeforeTime();
        int index = binarySearch(arr, 0, arr.length - 1, arr[18450]);
//        SortHelp.printAfterTime();

        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到，下标为=" + index);
        }

//        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13, 13, 13, 13, 15, 16, 17, 18, 19, 20};
//        List<Integer> indexList = binarySearchAll(arr, 0, arr.length - 1, 13);
//        System.out.println("resIndexList=" + indexList);
    }

    public static int binarySearch(int[] arr, int left, int right, int val) {
        System.out.println("哈哈哈");

        if (left > right) {
            return  -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (val < midVal) {
            return binarySearch(arr, left, mid - 1, val);
        } else if (val > midVal) {
            return binarySearch(arr, mid + 1, right, val);
        } else {
            return mid;
        }
    }

    public static List<Integer> binarySearchAll(int[] arr, int left, int right, int val) {
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (val < midVal) {
            return binarySearchAll(arr, left, mid - 1, val);
        } else if (val > midVal) {
            return binarySearchAll(arr, mid + 1, right, val);
        } else {
            List<Integer> indexList = new ArrayList<Integer>();

            int tmpIndex = mid - 1;
            while (true) {
                if (tmpIndex < 0 || arr[tmpIndex] != val) {
                    break;
                }
                indexList.add(tmpIndex);
                tmpIndex--;
            }

            indexList.add(mid);

            tmpIndex = mid + 1;
            while (true) {
                if (tmpIndex > arr.length - 1 || arr[tmpIndex] != val) {
                    break;
                }
                indexList.add(tmpIndex);
                tmpIndex++;
            }

            return  indexList;
        }
    }



}

























