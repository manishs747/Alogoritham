package company.flipkart.makemefat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MenuImpl implements Menu {

	private Map<Integer,Item> itemMap = new HashMap<>();

	@Override
	public void createMenu(int id, String name, int price, int calories) {
		if(id <= 0) {
			throw new MenuException("Please enter valid Item Id");
		}
		if(itemMap.containsKey(id)) {
			throw new MenuException("Item already exist with given id");
		}
		if(name == null || name.isEmpty()) {
			throw new MenuException("Please enter valid Item Name");
		}
		if(price <= 0) {
			throw new MenuException("Please enter valid price");
		}

		itemMap.put(id, new Item(id, name, price, calories));
	}

	@Override
	public void updatePrice(int id, int price) {
		if(price <= 0) {
			throw new MenuException("Please enter valid price");
		}
		if(itemMap.containsKey(id)) {
			Item item = itemMap.get(id);
			item.setPrice(price);
			itemMap.put(id, item);
			return;
		}
		throw new MenuException("Not a Valid Item ID");
	}

	@Override
	public void serveCustomer(int price) {
		if(itemMap.isEmpty()) {
			throw new MenuException("No Item is Available to Serve Customer");
		}
		Item serverItem = null;
		if(price <= 0) {
			throw new MenuException("Please enter valid price");
		}

		/*for (int itemId : this.itemMap.keySet()) {
			Item item = this.itemMap.get(itemId);
			if(price%item.getPrice() == 0) {
				if(serverItem == null) {
					serverItem = item;
				}else {
					serverItem = getServeItem(serverItem, item,price);
				}	
			}
		}*/
		Map<Integer,Integer> count = new HashMap<>();
		List<Integer> items = new ArrayList<>();
		for(int item :itemMap.keySet()) {
			items.add(item);
		}
		serveCustomerHelper(price,items , count);
		if(serverItem == null) {
			throw new MenuException("Price not valid to serve customer");
		}else {
			int quantity =  price/serverItem.getPrice();
			
			System.out.println("We will Serve them "+serverItem.getName()+" X "+quantity);
		}
	}
	
	public int serveCustomerHelper(int price,List<Integer> items,Map<Integer,Integer> count) {
		if(  price <= 0  )  {
			return 0;
		}
		for(int item :items) {
			int itemCalori = itemMap.get(item).getCalories();
			int itemprice = itemMap.get(item).getPrice();
			
		   int cal1 =   itemCalori +  serveCustomerHelper(price - itemprice, items,count)  ;
		   int cal2  =  serveCustomerHelper(price , items,count) ;
		   if(cal1 > cal2 ) {
			   if (count.containsKey(item)) {
				   count.put(item, count.get(item)+1);
			   }else {
				   count.put(item, 1);
			   }
		   }
		   
		   
		}
		
		return 0;
	}

	private Item getServeItem(Item prevItem , Item newItem,int price) {
		int prevcal =  ((price/prevItem.getPrice()) *prevItem.getCalories());
		int newCal = ((price/newItem.getPrice()) *newItem.getCalories());
		return prevcal < newCal ?newItem : prevItem;
	}

	@Override
	public void printMenu() {
		System.out.println("Menu has");
		for (int itemId : this.itemMap.keySet()) {
			System.out.println(this.itemMap.get(itemId));
		}
	}

}
