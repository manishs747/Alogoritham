package design_patterns.creational.singleton;

public class EagerSingletonClass {
	private static volatile EagerSingletonClass singletonInstance = new EagerSingletonClass();

	//making constructor as private to prevent access to outsiders
	private EagerSingletonClass() {
	}

	public static EagerSingletonClass getInstance() {
		return singletonInstance;
	}
}
