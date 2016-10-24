package com.regular.test;

/**
 * 根据正则去切割-替换
 * 
 * @author Administrator
 * 
 */
public class Demo2 {
	// 根据空格对一段字符串进行切割。
	public static void splitDemo() {
		String str = "aa.bb.cc";
		str = "-1     99    4    23";
		String[] arr = str.split(" +");
		for (String s : arr) {
			System.out.println(s);
		}
	}

	// 根据重叠词进行切割
	public static void splitDemo2() {
		String str = "sdqqfgkkkhjppppkl";
		String[] arr = str.split("(.)\\1+");
		for (String s : arr) {
			System.out.println(s);
		}
	}

	// 把手机号替换成“*”号
	public static void replaceall() {
		String str = "联系我：13567012119联系我：13567012119联系我：13567012119联系我：13567012119联系我：13567012119联系我：13567012119";
		String reg = "1[34578]\\d{9}";
		str = str.replaceAll(reg, "******");
		System.out.println("替换后的帖子：" + str);

	}

}
