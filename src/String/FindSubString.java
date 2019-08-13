package String;

public class FindSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	//goood
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0){
			return 0;
		}
		if (haystack.length() == 0) {
			return -1;
		}
		int max = haystack.length() -needle.length();
		char first = needle.charAt(0);
		for (int i = 0; i <= max; i++) {
			if (haystack.charAt(i) != first) {
				while (++i < haystack.length() && haystack.charAt(i) != first);
			}
			// Found first character, now look at the rest of value
			if (i <= max) {
				int j = i+1;
				int end = j + needle.length() - 1; //it is one more than actual value
				for(int k = 1; k < needle.length() && haystack.charAt(j) == needle.charAt(k)  ;k++,j++ ) ;
				if(j == end) {
					return i;
				}
			}
		}
		return -1;
	}

}
