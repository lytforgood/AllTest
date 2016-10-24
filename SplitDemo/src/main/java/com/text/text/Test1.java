package com.text.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test1 {
	 //创建一个HashMap容器
    private static Map<String,ArrayList<String>> m = new HashMap<String,ArrayList<String>>();
    public static void main(String[] args) {
        String[] sc1 = new String[10];
        String[] sc2 = new String[10];
        String sk = "abc";
        String sl = "cde";
        //通过循环，创建两个数组
        for(int i=0;i<10;i++){
            sc1[i] = "c"+i;
            sc2[i] = "b"+i;
        }
        //通过方法putAdd（类似于重写put方法）实现一对多
        putAdd(sk,sc1);
        putAdd(sl,sc2);
        System.out.println(m);
    }
    //使用ArrayList实现一个Key对应一个ArrayList实现一对多
    public static void putAdd(String sr,String[] s){
        if(!m.containsKey(sr)){
            m.put(sr, new ArrayList<String>());
        }
        for(int i=0;i<s.length;i++){
            m.get(sr).add(s[i]);
        }
    }
}
