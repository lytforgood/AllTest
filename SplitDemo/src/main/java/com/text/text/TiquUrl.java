package com.text.text;

import java.net.MalformedURLException;

public class TiquUrl {
	public static void main(String[] args) throws MalformedURLException {
		getHost();
	}
	
	
	 /**
     * 提取域名
     * @throws MalformedURLException 
     * */
	public static String getHost() throws MalformedURLException {
		java.net.URL url = new java.net.URL("http://0-1.reaSnrenwp.com/asokdsa.com/");
		String host = url.getHost();// 获取主机名
		System.out.println("host:" + host);// 结果
		return host;
	}

}
