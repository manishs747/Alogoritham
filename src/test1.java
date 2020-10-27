public class test1 {


	public static void main(String[] args) {

		String a = "cdeoo", b = "oooab";
		System.out.println(checkPalindromeFormation(a,b));

	}


	public static boolean checkPalindromeFormation(String a, String b) {
		if (isPal(a) || isPal(b)) {
			return true;
		}
		if (check(a, b) ||check(b, a)) {
			return true;
		}
		return false;
	}

	public  static boolean check(String a, String b){
		int len = a.length();

		int i=0;
		for(i=0;i<len;i++){
			if(a.charAt(i) != b.charAt(len-1-i)){
				break;
			}
		}
		String str1 =a.substring(0,i);
		String str2 =b.substring(i,len);
        if(str1.length() != str2.length()){
        	return false;
		}
		return isPal(str1+str2);
	}

	public static boolean isPal(String s){
		return s.equals(new StringBuilder(s).reverse().toString())?true:false;
	}



	
	
	
}
