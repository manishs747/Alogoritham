package design_problems.vending_machine;




import design_problems.vendingmachine.SoldOutException;

import java.util.List;

public class VendingMachineImpl implements VendingMachine {

    private Inventory<Coin> cashInventory = new Inventory<Coin>();
    private Inventory<Item> itemInventory = new Inventory<Item>();
    private long totalSales;
    private int currentBalance;
    private Item currentItem;

    public VendingMachineImpl(){
        initialize();
    }

    private void initialize() {
        for (Item item : Item.values()) {
            itemInventory.put(item,5);
        }
        for (Coin item : Coin.values()) {
            cashInventory.put(item,5);
        }
    }


    @Override
    public long selectItemAndGetPrice(Item item) {
        if(itemInventory.hasItem(item)) {
            currentItem = item;
            return item.getPrice();
        }
        throw new SoldOutException("Sold Out, Please buy another item");
    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance += coin.getDenomination();
        cashInventory.add(coin);
    }

    @Override
    public List<Coin> refund() {
       /* List<design_problems.vendingmachine.Coin> refund = getChange(currentBalance);
       // updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;*/
        return null;
    }

    private void updateCashInventory(List<Coin> refund) {
        for (Coin coin : refund) {
            cashInventory.deduct(coin);
        }
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        return null;
    }

    @Override
    public void reset() {

    }
}
