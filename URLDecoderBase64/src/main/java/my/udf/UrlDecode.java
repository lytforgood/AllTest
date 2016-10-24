package my.udf;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.aliyun.odps.udf.UDF;
/**
 * url解码
 * @author Administrator
 *
 */
public class UrlDecode extends UDF{
	private static final String separators = "[`~!@#$%^&*()+=\\-{}\\[\\]|\\:;\"<>',.?/\\\\ \n\r\t]";
	  
    public UrlDecode() {  
    	
    }  

	 /**
     * UDF Evaluate接口
     * 
     * UDF在记录层面上是一对一，字段上是一对一或多对一。 Evaluate方法在每条记录上被调用一次，输入为一个或多个字段，输出为一个字段
     */
    public String  evaluate(String postdata) {

    	
    	String keyWord = postdata;
		try {
			//加上这一句不保错  %在url识别中是特殊字符
			String postdata2 = postdata.replaceAll("%(?![0-9a-fA-F]{2})", "%25");  
			keyWord = URLDecoder.decode(postdata2, "UTF-8");
//			keyWord = keyWord.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
//			keyWord = URLDecoder.decode(keyWord, "UTF-8");
//			keyWord = URLDecoder.decode(keyWord, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
		}  
        return keyWord;  
    }
}
