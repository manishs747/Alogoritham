import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class security {
	public static void main(String[] args) throws Exception {
		String key = "zDVbRUoYi_uGaUf94V4J3Q";
		String data = "{\"journey_id\":\"0987654321abcdef0987654321abcdef\"}";
		System.out.println(getSecretKey(key, data));
		
		
		//sha1=091153807b2fe7caac3aa4f1bad0b2ddee9b9166
	}
	
	
	public static String getSecretKey(String key, String data) throws Exception {
		  Mac sha256_HMAC = Mac.getInstance("HmacSHA1");
		  SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
		  sha256_HMAC.init(secret_key);
		  char [] ch = Hex.encodeHex(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
		  return "sha1="+String.valueOf(ch);
		}

}
