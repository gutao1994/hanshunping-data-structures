package com.atguigu.sparsearray;

public class SparseArray {

	public static void main(String[] args) {

		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[3][2] = 2;
		chessArr1[0][0] = 2;

		printArr(chessArr1);

		int sparseArr[][] = toSparseArr(chessArr1);
		System.out.println();
		printArr(sparseArr);

		int chessArr2[][] = fromSparseArr(sparseArr);
		System.out.println();
		printArr(chessArr2);
	}

	public static int[][] toSparseArr(int[][] arr) {
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {
					sum++;
				}
			}
		}

		int sparseArr[][] = new int[sum + 1][3];
		sparseArr[0][0] = arr[0].length;
		sparseArr[0][1] = arr.length;
		sparseArr[0][2] = sum;

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = arr[i][j];
				}
			}
		}

		return sparseArr;
	}

	public static int[][] fromSparseArr(int[][] arr) {
		int tmpArr[][] = new int[arr[0][0]][arr[0][1]];

		for (int i = 1; i < arr.length; i++) {
			tmpArr[arr[i][0]][arr[i][1]] = arr[i][2];
		}

		return tmpArr;
	}

	public static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%d\t", arr[i][j]);
			}
			System.out.println();
		}
	}



}


