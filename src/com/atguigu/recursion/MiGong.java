package com.atguigu.recursion;

public class MiGong {

	public static void main(String[] args) {

		char[][] map = genMiGong(10, 9);

		genObstacle3(map);

		System.out.println("地图的情况");
		printMap(map);

		setWay(map, 1, 1);

		System.out.println("\n小球走过，并标识过的 地图的情况");
		printMap(map);
	}

	/**
	 * ↓ → ↑ ←
	 */
	public static boolean setWay (char[][] map, int col, int row) {
		if (col == map.length - 2 && row == map[0].length - 2) { //首先判断是否到达目标点
			map[col][row] = '>';
			return true;
		}

		if (map[col][row] == 'o') { //当前所在的点没有走过，递归出去
			map[col][row] = '>';

			if (setWay(map, col + 1, row)) { //向下
				return true;
			} else if (setWay(map, col, row + 1)) { //向右
				return true;
			} else if (setWay(map, col - 1, row)) { //向上
				return true;
			} else if (setWay(map, col, row - 1)) { //向左
				return true;
			} else {
				map[col][row] = 'x';
				return false;
			}
		} else { //1:墙、障碍物    2:走过的点    3:无法走的点
			return false;
		}
	}

	/**
	 * ← → ↓ ↑
	 */
	public static boolean setWay2 (char[][] map, int col, int row) {
		if (col == map.length - 2 && row == map[0].length - 2) { //首先判断是否到达目标点
			map[col][row] = '>';
			return true;
		}

		if (map[col][row] == 'o') { //当前所在的点没有走过
			map[col][row] = '>';

			if (setWay2(map, col, row - 1)) { //向左
				return true;
			} else if (setWay2(map, col, row + 1)) { //向右
				return true;
			} else if (setWay2(map, col + 1, row)) { //向下
				return true;
			} else if (setWay2(map, col - 1, row)) { //向上
				return true;
			} else {
				map[col][row] = 'x';
				return false;
			}
		} else { //1:墙、障碍物    2:走过的点    3:无法走的点
			return false;
		}
	}

	/**
	 * → ↓ ← ↑
	 */
	public static boolean setWay3 (char[][] map, int col, int row) {
		if (col == map.length - 2 && row == map[0].length - 2) { //首先判断是否到达目标点
			map[col][row] = '>';
			return true;
		}

		if (map[col][row] == 'o') { //当前所在的点没有走过
			map[col][row] = '>';

			if (setWay3(map, col, row + 1)) {
				return true;
			} else if (setWay3(map, col + 1, row)) {
				return true;
			} else if (setWay3(map, col, row - 1)) {
				return true;
			} else if (setWay3(map, col - 1, row)) {
				return true;
			} else {
				map[col][row] = 'x';
				return false;
			}
		} else { //1:墙、障碍物    2:走过的点    3:无法走的点
			return false;
		}
	}

	/**
	 * ↓ ← ↑ →
	 */
	public static boolean setWay4 (char[][] map, int col, int row) {
		if (col == map.length - 2 && row == map[0].length - 2) { //首先判断是否到达目标点
			map[col][row] = '>';
			return true;
		}

		if (map[col][row] == 'o') { //当前所在的点没有走过
			map[col][row] = '>';

			if (setWay4(map, col + 1, row)) {
				return true;
			} else if (setWay4(map, col, row - 1)) {
				return true;
			} else if (setWay4(map, col - 1, row)) {
				return true;
			} else if (setWay4(map, col, row + 1)) {
				return true;
			} else {
				map[col][row] = 'x';
				return false;
			}
		} else { //1:墙、障碍物    2:走过的点    3:无法走的点
			return false;
		}
	}

	/**
	 * 生成迷宫
	 */
	public static char[][] genMiGong(int rows, int cols) {
		char[][] map = new char[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 || i == rows - 1) {
					map[i][j] = '-';
				} else if (j == 0 || j == cols - 1) {
					map[i][j] = '|';
				} else {
					map[i][j] = 'o';
				}
			}
		}

		return map;
	}

	/**
	 * 设置障碍
	 */
	public static void genObstacle(char[][] map) {
		map[4][1] = '-';
		map[4][2] = '-';
		map[4][3] = '-';
		map[3][3] = '|';
		map[2][3] = '-';
		map[2][2] = '-';

		map[6][3] = '-';
		map[6][4] = '-';
		map[6][5] = '-';
		map[6][6] = '-';
		map[6][7] = '-';
	}

	public static void genObstacle2(char[][] map) {
		map[7][1] = '-';
		map[7][2] = '-';
		map[7][3] = '-';
		map[7][4] = '-';
		map[7][5] = '-';
		map[6][5] = '|';
		map[5][5] = '|';
		map[4][5] = '|';
		map[3][5] = '|';
		map[3][4] = '-';
		map[3][3] = '-';
	}

	public static void genObstacle3(char[][] map) {
		map[3][1] = '-';
		map[3][2] = '-';
		map[3][3] = '-';
		map[3][4] = '-';
		map[5][4] = '-';
		map[5][5] = '-';
		map[5][6] = '-';
		map[5][7] = '-';
		map[7][1] = '-';
		map[7][2] = '-';
		map[7][3] = '-';
		map[7][4] = '-';
	}

	/**
	 * 打印迷宫
	 */
	public static void printMap(char[][] map) {
		for (char[] row : map) {
			for (char col : row) {
				System.out.print(col + " ");
			}

			System.out.println();
		}
	}


}












































































