package designpattern.singleton;

public enum EnumSingleton {
	INSTANCE;
	
	public void show(){
		System.out.println("my name is manish");
	}
	
	public static void main(String[] args) {
		EnumSingleton.INSTANCE.show();
	}
}
