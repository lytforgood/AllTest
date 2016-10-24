package com.air.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.json.format.WriteFile;

public class T1 {

	public static void main(String[] args) throws IOException {
		wordcount(
				"E:/笔记学习/天池比赛/机场客流量的时空分布预测/机场客流量的时空分布预测_初赛数据集20161017/test.txt",
				"E:/笔记学习/天池比赛/机场客流量的时空分布预测/机场客流量的时空分布预测_初赛数据集20161017/airport_gz_security_check_chusai_2ndround处理后.csv",
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
			if (line == 1) {
				System.out.println(tempString);
			} else {
					String[] dataStrings = tempString.split(",");
					String keyvalue="";
					try {
						SimpleDateFormat df1=new SimpleDateFormat("yyyy/M/dd HH:mm:ss");
						Date date=df1.parse(dataStrings[1].toString());
						SimpleDateFormat df2=new SimpleDateFormat("yyyyMMdd,HHmm");
						keyvalue = dataStrings[0] + "," + dataStrings[3] + "," +df2.format(date).substring(0,12);
					} catch (Exception e) {
						keyvalue = "";
					}
					
//					String[] dates = dataStrings[2].split("-");
//					 keyvalue = dataStrings[0] + "," + dataStrings[3] + "," + dataStrings[2]
//							+ "," + dataStrings[1]+ " "+dates[3]  + dates[4];
//					String keyvalue = dataStrings[0] + "," + dataStrings[1]
//							+ "," + dates[0] + "-" + dates[1] + "-" + dates[2]
//							+ "," + dates[3] + "-" + dates[4] + "-" + dates[5];
//					System.out.println(keyvalue);
//System.out.println(keyvalue);
					if (keyvalue.length()>4) {
						WriteFile.writeFileByLines(writeFileString, keyvalue + "\r");
					}
					 
			}
//			if (line == 10) {
//				break;
//			}
			// System.out.println("line " + line + ": " + tempString);
			line++;
		}
		reader.close();

	}

}
