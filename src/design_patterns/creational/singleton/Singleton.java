package design_patterns.creational.singleton;

//http://javarevisited.blogspot.in/2011/06/volatile-keyword-java-example-tutorial.html

//Singleton example with double checked locking
public class Singleton{ 
	
	private static volatile Singleton _instance; // volatile variable

	public static Singleton getInstance() {
		if (_instance == null) {
			synchronized (Singleton.class) {
				if (_instance == null)
					_instance = new Singleton();
			}
		}
		return _instance;
	}
	
}
	
	



 
