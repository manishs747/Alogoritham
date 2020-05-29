package designpattern.singleton;

import java.io.Serializable;

public class SingletonSerializeAndDesrialize implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int x=100;
	
	private static volatile SingletonSerializeAndDesrialize singletonInstance = new SingletonSerializeAndDesrialize();

	private SingletonSerializeAndDesrialize() {

	}

	public static SingletonSerializeAndDesrialize getInstance() {
		return singletonInstance;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

}