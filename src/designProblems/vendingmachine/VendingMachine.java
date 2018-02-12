package designProblems.vendingmachine;

import java.util.List;

public interface VendingMachine {
	public abstract long selectItemAndGetPrice(Item item);

	public abstract void insertCoin(Coin coin);

	public abstract List<Coin> refund();

	public abstract Bucket<Item, List<Coin>> collectItemAndChange();

	public abstract void reset();
}
