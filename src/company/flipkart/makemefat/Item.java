package company.flipkart.makemefat;

public class Item {
	private  int id ;
	private  String name ;
	private   int price;
	private  int calories;
	public Item(int id,String name,int price,int calories) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.calories = calories;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	@Override
	public String toString() {
		return this.name+" for "+this.price+" bucks contains "+this.calories+" calories";
	}

}
