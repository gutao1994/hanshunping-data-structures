package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

	public static void main(String[] args) {
		String infixString = "1+((2+13)-5*6/3+10)-5*2";
		System.out.println(infixString);

		List<String> infixList = toInfixList(infixString);
		System.out.println(infixList);

		List<String> suffixList = toSuffixList(infixList);
		System.out.println(suffixList);

		int res = calculateSuffixList(suffixList);
		System.out.println(res);
	}


	public static List<String> toInfixList(String inFixString) {
		List<String> list = new ArrayList<String>();

		int index = 0;
		char cur;
		String intStr;

		do {
			cur = inFixString.charAt(index);

			if (cur < 48 || cur > 57) { //非数字
				list.add(cur + "");
				index++;
			} else { //数字
				intStr = "";

				while (index < inFixString.length() && (cur = inFixString.charAt(index)) >= 48 && cur <= 57) {
					intStr += cur;
					index++;
				}

				list.add(intStr);
			}
		} while (index < inFixString.length());

		return list;
	}

	public static List<String> toSuffixList(List<String> infixList) {
		List<String> list1 = new ArrayList<>();
		Stack<String> stack2 = new Stack<>();

		for (String cur : infixList) {
			if (cur.matches("\\d+")) { //数字
				list1.add(cur);
			} else if (cur.equals("(")) { //左括号
				stack2.push(cur);
			} else if (cur.equals(")")) { //右括号
				while (!stack2.peek().equals("(")) {
					list1.add(stack2.pop());
				}

				stack2.pop();
			} else { //运算符
				while (
					stack2.size() != 0 &&
					!isBracket(stack2.peek()) &&
					Oper.getPriority(stack2.peek()) >= Oper.getPriority(cur)
				) {
					list1.add(stack2.pop());
				}

				stack2.push(cur);
			}
		}

		while (stack2.size() != 0) {
			list1.add(stack2.pop());
		}

		return list1;
	}

	public static int calculateSuffixList(List<String> suffixList) {
		Stack<String> stack = new Stack<>();

		for (String cur : suffixList) {
			if (cur.matches("\\d+")) { //数字
				stack.push(cur);
			} else {
				int res = calculate(Integer.parseInt(stack.pop()), Integer.parseInt(stack.pop()), cur.charAt(0));
				stack.push(res + "");
			}
		}

		return Integer.parseInt(stack.pop());
	}

	/**
	 * 判断是否是左括号或者右括号
	 */
	public static boolean isBracket(String str) {
		return str.equals("(") || str.equals(")");
	}

	public static int calculate(int num1, int num2, char oper) {
		switch (oper) {
			case '+':
				return num2 + num1;
			case '-':
				return num2 - num1;
			case '*':
				return num2 * num1;
			case '/':
				return num2 / num1;
			default:
				throw new RuntimeException("不合法的运算符");
		}
	}
}


class Oper {
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;

	public static int getPriority(String oper) {
		int result = 0;

		switch (oper) {
			case "+":
				result = ADD;
				break;
			case "-":
				result = SUB;
				break;
			case "*":
				result = MUL;
				break;
			case "/":
				result = DIV;
				break;
			default:
				throw new RuntimeException("不存在该运算符" + oper);
		}

		return result;
	}
}





































