package com.regular.test;

/**
 * 正则表达式
 * 
 * @author Administrator
 * 
 */
public class Demo1 {
	public static void main(String[] args) {
		regular();
	}

	// 正则
	public static void regular() {
		System.out.println("a".matches("[a]"));
		System.out.println("aa".matches("[a]+"));
		System.out.println("abc".matches("[abc]{3,}"));
		System.out.println("abc".matches("[abc]+"));
		System.out.println("dshfshfu1".matches("[^abc]+"));
		System.out.println("abcdsaA".matches("[a-z]{5,}"));
		System.out.println("abcdsaA12".matches("[a-zA-Z]{5,}"));
		System.out.println("abcdsaA12".matches("[a-zA-Z0-9]{5,}"));
		System.out.println("abdxyz".matches("[a-c[x-z]]+"));
		System.out.println("bcbcbc".matches("[a-z&&[b-c]]{5,}"));
		System.out.println("tretrt".matches("[a-z&&[^b-c]]{5,}"));
	}

	// 只能输入数字
	public static void shuzi() {
		String str = "124354232";
		char[] arr = str.toCharArray();
		boolean flag = true;
		for (int i = 0; i < arr.length; i++) {
			if (!(arr[i] >= 48 && arr[i] <= 57)) {
				flag = false;
			}
		}
		System.out.println(flag ? "输入正确" : "输出只能是数字");

	}

	// 只能输入数字 正则
	public static void shuzi2() {
		String str = "12435423a2";
		boolean flag = str.matches("[0-9]+");
		System.out.println(flag ? "输入正确" : "只能输入数字");
	}

	//校验QQ号，要求：必须是5~15位数字，0不能开头。没有正则表达式之前
	public static void checkQQ(String qq)
	{
		int len = qq.length();
		if(len>=5 && len <=15)
		{
			if(!qq.startsWith("0"))
			{
				try
				{
					long l = Long.parseLong(qq);
					System.out.println("qq:"+l);
				}		
				catch (NumberFormatException e)
				{
					System.out.println("出现非法字符");
				}
			}
			else
				System.out.println("不可以0开头");
		}
		else
			System.out.println("QQ号长度错误");
	}

	//[1-9][0-9]{4,14}   [1-9]表示是第一位数字是会出现1-9范围之间的其中一个，下来的数字范围会出现在0-9之间，至少出现4次，最多出现14次。
	public static void checkQQ2()         
	{                                     
	String qq = "12345";              
	String reg = "[1-9][0-9]{4,14}";  
	boolean b = qq.matches(reg);      
	System.out.println("b="+b);                                 
	}         
//匹配是否为一个合法的手机号码。
	public static void checkTel()                                                   
	{                                                                               
	String tel = "25800001111";                                                 
	String reg = "1[35]\\d{9}";//在字符串中，定义正则出现\ 要一对出现。         
	boolean b= tel.matches(reg);                                                
	System.out.println(tel+":"+b);                                              
	}           

}
