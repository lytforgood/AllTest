package my.udf;


import com.aliyun.odps.udf.UDF;
/**
 * Base64解码
 * @author Administrator
 *
 */
public class BaseDecode64 extends UDF{
	private static final String separators = "[`~!@#$%^&*()+=\\-{}\\[\\]|\\:;\"<>',.?/\\\\ \n\r\t]";
	  
    public BaseDecode64() {  
    	
    }  

	 /**
     * UDF Evaluate接口
     * 
     * UDF在记录层面上是一对一，字段上是一对一或多对一。 Evaluate方法在每条记录上被调用一次，输入为一个或多个字段，输出为一个字段
     */
    public String  evaluate(String postdata) {

    	
    	String keyWord = postdata;
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
