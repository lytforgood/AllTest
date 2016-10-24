package com.regular.eg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配 boolean 查找 替换 分割 删除(替换为空) 输出所有匹配到的字符串
 * 
 * @author Administrator
 * 
 */
public class Example1 {

	public static void main(String[] args) {
		test2();
	}

	//find()是部分匹配  匹配中文[\\u4e00-\\u9fa5]+ 一个或多个汉字^[\\u0391-\\uFFE5]+$
	static void test1() {
		String text = "aaa晚上睡觉xx 阿萨德";
		System.out.println(text.matches("^[\\u0391-\\uFFE5]+$"));
		Pattern r = Pattern.compile("[\\u4e00-\\u9fa5]");// 正则表达式的编译表示
		Matcher m = r.matcher(text);// 对输入字符串进行解释和匹配操作的引擎
		// 在字符串中查询字符或者字符串find()是部分匹配  每次find()从开始匹配往后递进
		if (m.find()) {
		System.out.println("Found value: " + m.group(0));
		}
		int count = 0;
		while (m.find()) {
			count++;
			System.out.println("Match number " + count);
			// 根据查询到的起始位置选择
			System.out.println(text.substring(m.start(), m.end()));
		}
	}

	// 邮箱  matches()全部匹配
	static void test2() {
		// 要验证的字符串
		String str = "service@xsoftlab.net";
		// 邮箱验证规则
		String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
		// 编译正则表达式
		Pattern pattern = Pattern.compile(regEx);
		// 忽略大小写的写法
		// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		// 字符串是否与正则表达式相匹配
		boolean rs = matcher.matches();
		System.out.println(rs);
		// 根据查询到的起始位置选择
		System.out.println(str.substring(matcher.start(), matcher.end()));
		if (matcher.matches()) {
			System.out.println("Found value: " + matcher.group(0));
		}
	}

	// 替换 把手机号替换成“*”号
	static void test3() {
		String str = "联系我：13567012119联系我：13567012119联系我：13567012119联系我：13567012119联系我：13567012119联系我：13567012119";
		String reg = "1[34578]\\d{9}";
		str = str.replaceAll(reg, "******");
		System.out.println("替换后的帖子：" + str);
	}

	// 分割 根据重叠词进行切割--把重复的单词当成分隔符
	static void test4() {
		String str = "sdqqfgkkkhjppppkl";
		String[] arr = str.split("(.)\\1+");
		for (String s : arr) {
			System.out.println(s);
		}
	}

	// 删除
	static void test5() {
		String text = "aaa晚上睡觉xx 阿萨德";
		System.out.println(text.matches("^[\\u0391-\\uFFE5]+$"));
		// Pattern r = Pattern.compile("[\\u4e00-\\u9fa5]");//正则表达式的编译表示
		// Matcher m = r.matcher(text);//对输入字符串进行解释和匹配操作的引擎
		text = text.replaceAll("[\\u4e00-\\u9fa5]", "");
		System.out.println("替换后的帖子：" + text);
	}

	//输出所有匹配到的字符串
	static void test6() {
		String str = "联系我：13567012119联系我：13567012119联系我：13567012119联系我：13567012119联系我：13567012119联系我：13567012119";
		String reg = "1[34578]\\d{9}";
		Pattern pattern = Pattern.compile(reg);
		// 忽略大小写的写法
		// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher m = pattern.matcher(str);
		int count = 0;
		while (m.find()) {
			count++;
			System.out.println("Match number " + count);
			// System.out.println("start(): "+m.start());
			// System.out.println("end(): "+m.end());
			System.out.println(str.substring(m.start(), m.end()));
		}
	}
}
