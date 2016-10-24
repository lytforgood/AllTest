package com.text.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import com.json.format.WriteFile;
/**
 * 切割大文件
 * @author Administrator
 *
 */
public class SplitMap {
	// 按行读取 以行为单位读取文件内容，一次读一整行：类似于map程序
	public static void wordcount(String fileName) throws IOException {
		File file = new File(fileName);
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		int line = 1;
		// 一次读入一行，直到读入null为文件结束
		while ((tempString = reader.readLine()) != null) {
			// 显示行号
			if (line >=100) {
				System.out.println("停止");
				break;
			}
			WriteFile.writeFileByLines("E:/笔记学习/社交网络会议/数据堂样例/社交网络微博用户关系数据/微博关系数据样例/relsemple2.json", tempString + "\r");
			line++;
		}
		reader.close();

	}

	public static void main(String[] args) throws IOException {
		wordcount("E:/笔记学习/社交网络会议/数据堂样例/社交网络微博用户关系数据/微博关系数据样例/relsemple.json");
	}

}
