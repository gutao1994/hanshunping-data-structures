package com.atguigu.recursion;

public class MiGong {

	public static void main(String[] args) {

		char[][] map = genMiGong(10, 9);

		genObstacle(map);

		System.out.println("地图的情况");
		printMap(map);

		setWay(map, 1, 1);

		System.out.println("\n小球走过，并标识过的 地图的情况");
		printMap(map);
	}

	public static boolean setWay (char[][] map, int col, int row) {
		if (col == map.length - 2 && row == map[0].length - 2) { //首先判断是否到达目标点
			map[col][row] = '>';
			return true;
		}

		if (map[col][row] == 'o') { //当前所在的点没有走过
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
	 * 生成迷宫
	 */
	public static char[][] genMiGong(int rows, int cols) {
		char[][] map = new char[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 || i == rows - 1) {
					map[i][j] = '-';
				} else if ( (j == 0 && i != 0 && i != rows - 1) || (j == cols - 1 && i != 0 && i != rows - 1) ) {
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












































































