package designProblems.vendingmachine;

import java.util.List;

public class VendingMachineImpl implements VendingMachine {
	
	public static final int initialCoinCount = 5;
	public static final int initialItemCount = 5;
	
	private Inventory<Coin> cashInventory = new Inventory<Coin>();
	private Inventory<Item> itemInventory = new Inventory<Item>();
	private long totalSales;
	private Item currentItem;
	private long currentBalance;
	
	/**
	 * 
	 */
	public VendingMachineImpl() {
		initialize();
	}
	
	private void initialize() {
		for (Coin c : Coin.values()) {
			cashInventory.put(c, initialCoinCount);
		}
		for (Item i : Item.values()) {
			itemInventory.put(i, initialItemCount);
		}

	}

	@Override
	public long selectItemAndGetPrice(Item item) {
		return 0;
	}

	@Override
	public void insertCoin(Coin coin) {

	}

	@Override
	public List<Coin> refund() {
		return null;
	}

	@Override
	public Bucket<Item, List<Coin>> collectItemAndChange() {
		return null;
	}

	@Override
	public void reset() {

	}

}
