package com.atguigu.stack;

public class Test1 {

	public static void main(String[] args) {

		String a = "aaa";
		String b = "aaa";

		System.out.println(a == b);

//		test1(a, b);

		String shortA = a.substring(0, 1);
		String shortB = b.substring(0, 1);

		System.out.println(shortA == shortB);

//		test1(, );

//		System.out.println("1" == "1");
//
//		Aa a1 = new Aa();
//		Aa a2 = new Aa();
//		System.out.println(a1 == a2);
	}

	public static void test1(String str1, String str2) {
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str1 == str2);
	}
}

class Aa {

}
