package com.atguigu.stack;

public class Calculator1 {

	public static void main(String[] args) {

		String expression = "1-2*12-40+30";
		int length = expression.length();
		int index = 0;

		int num1 = 0;
		int num2 = 0;
		char oper = ' ';
		int res = 0;

		ArrayStack1<Integer> numStack = new ArrayStack1<Integer>(100);
		ArrayStack1<Character> operStack = new ArrayStack1<Character>(100);

		char ch = ' ';
		String keepNum = "";

		while (true) {
			ch = expression.substring(index, index + 1).charAt(0);

			if (isOper(ch)) { //是运算符
				if (operStack.isEmpty() || operProperty(ch) > operProperty(operStack.peek())) {
					operStack.push(ch);
				} else {
					num1 = numStack.pop();
					num2 = numStack.pop();
					oper = operStack.pop();

					res = cal(num1, num2, oper);

					numStack.push(res);
					operStack.push(ch);
				}
			} else { //是数字
				keepNum += ch;

				if (
					index == length - 1 ||
					isOper( expression.substring(index + 1, index + 2).charAt(0) )
				) {
					numStack.push(Integer.parseInt(keepNum));
					keepNum = "";
				}
			}

			if (++index >= length) {
				break;
			}
		}

		while (true) {
			if (operStack.isEmpty())
				break;

			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();

			res = cal(num1, num2, oper);

			numStack.push(res);
		}

		System.out.printf("表达式 %s = %d", expression, numStack.pop());
	}

	public static boolean isOper(char value) {
		return value == '+' || value == '-' || value == '*' || value == '/';
	}

	public static int operProperty(char value) {
		if (value == '*' || value == '/') {
			return 1;
		} else if (value == '+' || value == '-') {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * num1 第一个pop出来的数
	 * num2 第二个pop出来的数
	 */
	public static int cal(int num1, int num2, char oper) {
		int res = 0;

		switch (oper) {
			case '+':
				res = num2 + num1;
				break;
			case '-':
				res = num2 - num1;
				break;
			case '*':
				res = num2 * num1;
				break;
			case '/':
				res = num2 / num1;
				break;
		}

		return res;
	}
}


class ArrayStack1<T> {

	private int maxSize;

	private T[] stack;

	private int top = -1;

	public ArrayStack1(int maxSize) {
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

	public T peek() {
		return this.stack[this.top];
	}

	public void printStack() {
		for (int i = this.top;i >= 0; i--) {
			System.out.printf("stack[%d]=", i);
			System.out.println(this.stack[i]);
		}
	}
}


























