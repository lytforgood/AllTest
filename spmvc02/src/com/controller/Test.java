package com.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Test {
	
	//如果直接 className.class 日志输出到全局的 即rootLogger 指定的文件中
	private static  Logger logger = Logger.getLogger(Test.class.getName());
	//如果指定logger名字，则是把日志，输出到pay-log 指定的日志文件中去
    Logger logger2 = Logger.getLogger("pay-log");
	@RequestMapping("/1.do")  
	public String reg(){
		System.out.println("111111111");
//		# Log4j建议只使用FATAL ,ERROR ,WARN ,INFO ,DEBUG这五个级别。
//		# ERROR 为严重错误 主要是程序的错误
//		# WARN 为一般警告，比如session丢失
//		# INFO 为一般要显示的信息，比如登录登出
//		# DEBUG 为程序的调试信息
		logger.info("日志信息开始了!");
		logger.error("解析数字出现异常");
		logger2.info("日22222!");
		return "index";
	}
}
