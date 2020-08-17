package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		String str1 = "  15 + 5 * 2 -          ";

		String[] strArr = str1.split(" ");

		List<String> list = new ArrayList<String>();

		for (String strTmp : strArr) {
			list.add(strTmp);
		}

		System.out.println(list);
	}

}
