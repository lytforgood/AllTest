package com.air.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.json.format.WriteFile;

public class DataSplit2 {

	public static void main(String[] args) throws IOException {
		wordcount(
				"E:/笔记学习/天池比赛/机场客流量的时空分布预测/第一赛季/1021x.csv",
				"E:/笔记学习/天池比赛/机场客流量的时空分布预测/第一赛季/1021re1x.csv",
				"p2_fishurls_28_493_host");
	}

	// 按行读取 以行为单位读取文件内容，一次读一整行：类似于map程序
	public static void wordcount(String fileName, String writeFileString,
			String tablename) throws IOException {
		File file = new File(fileName);
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		int line = 1;
		// 一次读入一行，直到读入null为文件结束
		while ((tempString = reader.readLine()) != null) {
//			if (line == 1) {
//				System.out.println(tempString);
//			} else {
				try {
					String[] dataStrings = tempString.split(",");
					String[] dates = dataStrings[2].split("-");
					String keyvalue = dataStrings[0] + "," + dataStrings[1] + "," + dataStrings[2]
							+ "," + dataStrings[1]+dataStrings[2];
//					String keyvalue = dataStrings[0] + "," + dataStrings[1]
//							+ "," + dates[0] + "-" + dates[1] + "-" + dates[2]
//							+ "," + dates[3] + "-" + dates[4] + "-" + dates[5];
//					System.out.println(keyvalue);

					 WriteFile.writeFileByLines(writeFileString, keyvalue + "\r");
				} catch (Exception e) {
				}
			}
//			if (line == 10) {
//				break;
//			}
			// System.out.println("line " + line + ": " + tempString);
			line++;
//		}
		reader.close();

	}

}
