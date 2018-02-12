package String;

public class Captilize {
	
	
	public static void main(String[] args) {
		 String str = capitalizeString("heavy calf muscle");
		 System.out.println(str);
	}

	
	public static String capitalizeString(String string) {
		  char[] chars = string.toLowerCase().toCharArray();
		  StringBuffer sb = new StringBuffer();
		  boolean found = false;
		  for (int i = 0; i < chars.length; i++) {
		     
		    if (Character.isWhitespace(chars[i]) || chars[i]==' ') { // You can add other chars here
		    chars[i+1] = Character.toUpperCase(chars[i+1]);
		    }else{
		    	sb.append(chars[i]);
		    }
		  }
		  return sb.toString();
		}
}
