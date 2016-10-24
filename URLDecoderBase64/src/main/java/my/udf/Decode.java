package my.udf;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.aliyun.odps.udf.UDF;
/**
 * 先url解码后base64解码----如果url解码后无base64的编码，强制解码出现乱码
 * @author Administrator
 *
 */
public class Decode extends UDF{
	private static final String separators = "[`~!@#$%^&*()+=\\-{}\\[\\]|\\:;\"<>',.?/\\\\ \n\r\t]";
	  
    public Decode() {  
    	
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
			String postdata2 = postdata.replaceAll("%", "%25");  
			keyWord = URLDecoder.decode(postdata2, "UTF-8");
//			keyWord = keyWord.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
//			keyWord = URLDecoder.decode(keyWord, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
		}  
        String[] tokens = keyWord.split(separators);
        String base64decode="";
		for (int i = 0; i < tokens.length; i++) {
			String da = tokens[i];
			try {
//				String decoded = Base64.decode(da, "UTF-8");
				String decoded = new String(Base64Decode.decode_base64(da.getBytes()));
				base64decode=base64decode+decoded;
//		        System.out.println(decoded);  
			} catch (Exception e) {
				base64decode=base64decode+da;
//				 System.out.println(da);  
			}
		}
        return base64decode;  
    }
}
