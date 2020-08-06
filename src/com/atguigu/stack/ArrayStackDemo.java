package com.atguigu.stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {

		ArrayStack<String> stack = new ArrayStack<String>(4);
		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("please input: show,push,pop,exit");

			key = scanner.next();

			switch (key) {
				case "show":
					stack.printStack();
					break;
				case "push":
					System.out.println("please input push value");
					String value = scanner.next();

					try {
						stack.push(value);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case "pop":
					try {
						String res = stack.pop();
						System.out.println("出栈的数据是：" + res);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case "exit":
					scanner.close();
					loop = false;
					break;
				default:
					break;
			}
		}

		System.out.println("程序结束");
	}
}


class ArrayStack<T> {

	private int maxSize;

	private T[] stack;

	private int top = -1;

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		this.stack = (T[]) new Object[this.maxSize];
	}

	public boolean isFull()
	{
		return this.top == this.maxSize - 1;
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public void push(T value) {
		if (this.isFull()) {
			throw new RuntimeException("栈满，无法push");
		}

		this.stack[++this.top] = value;
	}

	public T pop() {
		if (this.isEmpty()) {
			throw new RuntimeException("栈空，无法pop");
		}

		return this.stack[this.top--];
	}

	public void printStack() {
		for (int i = this.top;i >= 0; i--) {
			System.out.printf("stack[%d]=", i);
			System.out.println(this.stack[i]);
		}
	}
}


























































