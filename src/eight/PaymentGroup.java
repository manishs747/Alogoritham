package eight;

import java.util.List;

public class PaymentGroup {
	String name;
	List<String> methods;
	
	public PaymentGroup() {
		// TODO Auto-generated constructor stub
	}
	public PaymentGroup(String name,List<String> methods) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.methods = methods;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name.toString();
	}

}
