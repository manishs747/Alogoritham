package designProblems.vendingmachine;

/*
 * A parameterized utility class to hold two different object.
 */
public class Bucket<E1, E2> {

	private E1 first;
	private E2 second;

	/**
	 * @param first
	 * @param second
	 */
	public Bucket(E1 first, E2 second) {
		super();
		this.first = first;
		this.second = second;
	}

	public E1 getFirst() {
		return first;
	}

	public void setFirst(E1 first) {
		this.first = first;
	}

	public E2 getSecond() {
		return second;
	}

	public void setSecond(E2 second) {
		this.second = second;
	}

}
