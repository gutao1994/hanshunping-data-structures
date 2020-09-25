package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SortHelp {

    public static void printBeforeTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date);
        System.out.println("排序前的时间是=" + dateStr);
    }

    public static void printAfterTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date);
        System.out.println("排序后的时间是=" + dateStr);
    }

    public static int[] genArr(int num) {
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = (int)(Math.random() * 100001); //生成一个[0, 100000] 数
        }

        return arr;
    }
}














