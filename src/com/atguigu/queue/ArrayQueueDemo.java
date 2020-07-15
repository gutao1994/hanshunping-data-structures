package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {

		char key = 'a';

		Scanner scanner = new Scanner(System.in);

		while (true) {
			key = scanner.next().charAt(0);
			System.out.println(key);
			if (key == 'e')
				break;
		}
	}



}


