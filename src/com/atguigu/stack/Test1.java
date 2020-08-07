package com.atguigu.stack;

public class Test1 {

	public static void main(String[] args) {

		String a = "aaa";
		String b = "aaa";

		System.out.println(a == b);

		System.out.println("1" == "1");

		Aa a1 = new Aa();
		Aa a2 = new Aa();
		System.out.println(a1 == a2);
	}

}

class Aa {

}


