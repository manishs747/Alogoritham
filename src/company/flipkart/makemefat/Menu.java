package company.flipkart.makemefat;


public interface Menu {
	public void createMenu(int id,String name,int price,int calories);
	public void updatePrice(int id,int price) ;
	public void serveCustomer(int price);
	public void printMenu();
}
