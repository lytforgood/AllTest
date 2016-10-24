package com.text.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import com.json.format.WriteFile;

public class Sql2 {
	// 按行读取 以行为单位读取文件内容，一次读一整行：类似于map程序
	public static void wordcount(String fileName, String writeFileString)
			throws IOException {
		File file = new File(fileName);
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		int line = 1;
		// 一次读入一行，直到读入null为文件结束
		WriteFile
				.writeFileByLines(
						writeFileString,
						"create table if not  exists p1_isfish_tmp16  as select url from  adl_tianchi_fishurls_training_fdt  where url like '%http://www.icbcddu.com%'\r");
		while ((tempString = reader.readLine()) != null) {
			// 显示行号
			// StringTokenizer stringTokenizer = new
			// StringTokenizer(tempString);
			if (tempString.length() < 4) {
				System.out.println(tempString);
			} else {
				String sql = "or url like '%" + tempString + "%'";
				WriteFile.writeFileByLines(writeFileString, sql + "\r");
			}

			// 遍历
			// while (stringTokenizer.hasMoreElements()) {
			// // 获取每个值
			// String wordValue = stringTokenizer.nextToken();
			// // 设置map输出的key值
			// WriteFile.writeFileByLines("E:/b.txt", wordValue + "," + "1");
			// }

			// System.out.println("line " + line + ": " + tempString);
			line++;
		}
		reader.close();

	}

	public static void main(String[] args) throws IOException {
		wordcount("E:/笔记学习/天池比赛/阿里云安全算法/第一赛季数据/较为确定的35条.txt",
				"E:/笔记学习/天池比赛/阿里云安全算法/第一赛季数据/较为确定的35条sql.txt");
	}

}
