package com.regular.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取需要使用到正则的两个对象：使用的是用正则对象Pattern 和匹配器Matcher。 
 * 用法： 范例： Pattern p =Pattern.compile("a*b"); 
 * Matcher m = p.matcher("aaaaab"); 
 * boolean b =m.matches(); 
 * 步骤： 1，先将正则表达式编译成正则对象。使用的是Pattern类一个静态的方法。compile(regex);
 * 2，让正则对象和要操作的字符串相关联，通过matcher方法完成，并返回匹配器对象。
 *  3，通过匹配器对象的方法将正则
 * 
 */
public class Demo3 {
	public static void main(String[] args) {
		getDemo();
	}
	//获取由3个字母组成的单词。
	public static void getDemo()
	{
		String str = "da jia zhu yi le,ming tian bu fang jia,xie xie!";
		//想要获取由3个字母组成的单词。
		//刚才的功能返回的都是一个结果，只有split返回的是数组，但是它是把规则作为分隔符，不会获取符合规则的内容。
		//这时我们要用到一些正则对象。
		String reg = "\\b[a-z]{3}\\b";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str);
		while(m.find())
		{
			System.out.println(m.start()+"...."+m.end());
			System.out.println("sub:"+str.substring(m.start(),m.end()));
			System.out.println(m.group());
		}
//		System.out.println(m.find());//将规则对字符串进行匹配查找。
//		System.out.println(m.find());//将规则对字符串进行匹配查找。
//		System.out.println(m.group());//在使用group方法之前，必须要先找，找到了才可以取。
	}
	//校验邮件
	public static void checkMail()
	{
		String mail = "abc123@sina.com.cn";
		mail = "1@1.1";
		String reg = "[a-zA-Z_0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
		reg = "\\w+@\\w+(\\.\\w+)+";//简化的规则。笼统的匹配。
		boolean b = mail.matches(reg);
		System.out.println(mail+":"+b);
	}



}
