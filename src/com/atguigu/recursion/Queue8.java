package com.atguigu.recursion;

public class Queue8 {
    int[] arr = new int[8];
    int count;
    int count2;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.placeQueue(0);

        System.out.println("共有" + queue8.count + "种放置方案");
        System.out.println("共走了" + queue8.count2 + "步");
    }

    public void placeQueue(int row) {
        if (row == 8) {
            count++;
            print();
            return;
        }

        for (int col = 0; col < 8; col++) {
            count2++;

            arr[row] = col;

            if (canPlace(row, col)) {
                placeQueue(row + 1);
            }
        }
    }

    public boolean canPlace(int row, int col) {
        for (int i = 0; i < row; i++) {
            if ((arr[i] == col) || (row - i == Math.abs(col - arr[i]))) {
                return false;
            }
        }

        return true;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



}

















































