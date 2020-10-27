package design_patterns.creational.singleton;


/**
* Singleton pattern example with static factory method
*/

//Read more: http://javarevisited.blogspot.com/2012/07/why-enum-singleton-are-better-in-java.html#ixzz4VLDFK6Wk
public class SingletonStaticFactory {
	
	  //initailzed during class loading
    private static final Singleton INSTANCE = new Singleton();
  
    //to prevent creating another instance of Singleton
    private SingletonStaticFactory(){}

    public static Singleton getSingleton(){
        return INSTANCE;
    }

}
