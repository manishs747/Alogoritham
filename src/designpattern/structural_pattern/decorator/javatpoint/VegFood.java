package designpattern.structural_pattern.decorator.javatpoint;

public class VegFood implements Food {

	@Override
	public double foodPrice() {
		  return 50.0; 
	}

	@Override
	public String prepareFood() {
		   return "Veg Food";  
	}

}
