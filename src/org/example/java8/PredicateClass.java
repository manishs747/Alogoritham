package org.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateClass {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();

		people.add(new Person("Joe", 48));
		people.add(new Person("Mary", 30));
		people.add(new Person("Mike", 73));
		//Predicate<Person> preOlder = (p)->p.getAge()>=65;
		Predicate<Person> preYounger = (p)->p.getAge()<40;
		
		display(people, preYounger);
		
	}
	
	private static void display(List<Person> people,Predicate<Person> pred){
		people.forEach(p->{
			if(pred.test(p)){
				System.out.println(p);
			}
		});
	}

}
