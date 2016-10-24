package com.text.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.json.format.WriteFile;

public class Reduce {

	private static Map<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();

	private static void contentput(String sr, String sc1) {
		if (!m.containsKey(sr)) {
			m.put(sr, new ArrayList<String>());
		}
		m.get(sr).add(sc1);
	}

	private static void reducebykey(String path) throws IOException {
		File file = new File(path);
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		int line = 1;
		// 一次读入一行，直到读入null为文件结束
		while ((tempString = reader.readLine()) != null) {
			// 显示行号
			String[] strings = tempString.split(",");
			contentput(strings[0], strings[1]);

			// System.out.println("line " + line + ": " + tempString);
			line++;
		}
		reader.close();
	}

	public static void main(String[] args) throws IOException {
		reducebykey("E:/b.txt");
		// System.out.println(m);
		m.keySet();
		for (String key : m.keySet()) {
			ArrayList<String> value = m.get(key);
			int sum = 0;
			for (String string : value) {
				sum += Integer.valueOf(string);
			}
			// System.out.println(key+"\t"+sum);
			WriteFile.writeFileByLines("E:/c.txt", key + "\t" + sum);
		}
	}

}
