package org.example.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionIteration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> strings = new ArrayList<String>();
		strings.add("AAA");
		strings.add("bbb");
		strings.add("CCC");
		strings.add("ddd");
		strings.add("EEE");
		
		Collections.sort(strings);
		System.out.println("Simple sort");
		char[] st ={'a','b'};
		strings.forEach(s ->System.out.println(st));
		
		Comparator<String> comp = (str1, str2) -> {return str1.compareToIgnoreCase(str2);};
	    Collections.sort(strings, comp);
		System.out.println("Sort with comparator");
		strings.forEach(s ->System.out.println(s));//for each iterator

	}

}
