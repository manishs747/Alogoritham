package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ola.main;

public class StringSplit {
	
	public static void main(String[] args) {
		
		String stopwords =  "delay,late,swiggy";
        List<String> stopWordsList = new ArrayList<String>(Arrays.asList(stopwords.split(",")));
		String s = "  you      delay    1 plate or multiple plate of kababs they will supply only a tiny amount of salad & chutny to serve with single plate.So buying multiple plates does not serve you better from this restaurant.";
		
		
		
		getFlag(stopWordsList, s);
		
		
		  
	}

	private static boolean getFlag(List<String> stopWordsList, String s) {
        for (String stopword : stopWordsList) {
            String[] comments = s.trim().split(',');
            for (String comment : comments) {
                if (stopword.equalsIgnoreCase(comment)) {
                    return true;
                }
                System.out.println("Comment:"+comment+" STOPW:"+stopword);
            }
            
        }
        return false;
	}

}
