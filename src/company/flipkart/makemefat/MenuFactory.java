package company.flipkart.makemefat;

public class MenuFactory {
	
	public static Menu createMenu() {
		return new MenuImpl();
	}

}
