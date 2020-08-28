package com.atguigu.recursion;

public class Test1 {

    public static void main(String[] args) {
        printNum(10);

        System.out.println();
        System.out.println();

        int res = factorial(6);
        System.out.println(res);
    }

    public static void printNum(int num) {
        if (num > 1) {
            printNum(num - 1);
        }

        System.out.print(num + "  ");
    }

    public static int factorial(int num) {
        if (num > 2) {
            return  num * factorial(num - 1);
        } else {
            return num;
        }
    }

}






































