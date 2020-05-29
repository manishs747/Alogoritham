package designproblems.vendingmachine;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }

    private void updateCashInventory(List<Coin> refund) {
        for (Coin coin : refund) {
            cashInventory.deduct(coin);
        }
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();
        itemInventory.deduct(currentItem);
        List<Coin> change = collectChange();
        return new Bucket<Item, List<Coin>>(item, change);
    }


    private Item collectItem() throws NotSufficientChangeException, NotFullPaidException{
        if(isFullPaid()){
            if(hasSufficientChange()){
                itemInventory.deduct(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("Not Sufficient change in Inventory");
        }
        long remainingBalance = currentItem.getPrice() - currentBalance;
        throw new NotFullPaidException("Price not full paid, remaining : ", remainingBalance);
    }

    private List<Coin> collectChange() {
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        currentBalance = 0;
        currentItem = null;
        return change;
    }



    private boolean hasSufficientChange() {
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }

    private boolean hasSufficientChangeForAmount(long amount){
        boolean hasChange = true;
        try{
            getChange(amount);
        }catch(NotSufficientChangeException nsce){
            return hasChange = false;
        }
        return hasChange;
    }

    private List<Coin> getChange(long amount) throws NotSufficientChangeException{
        List<Coin> changes = Collections.EMPTY_LIST;
        if (amount > 0) {
            changes = new ArrayList<Coin>();
            long balance = amount;
            while(balance > 0) {
                if( balance >= Coin.QUARTER.getDenomination() && cashInventory.hasItem(Coin.QUARTER)) {
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.QUARTER.getDenomination();
                    continue;
                } else if ( balance >= Coin.DIME.getDenomination() && cashInventory.hasItem(Coin.QUARTER)) {
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.DIME.getDenomination();
                    continue;
                }
                else if ( balance >= Coin.NICKLE.getDenomination() && cashInventory.hasItem(Coin.QUARTER)) {
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.NICKLE.getDenomination();
                    continue;
                }
                else if ( balance >= Coin.PENNY.getDenomination() && cashInventory.hasItem(Coin.QUARTER)) {
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.PENNY.getDenomination();
                    continue;

                } else {
                    throw new NotSufficientChangeException("NotSufficientChange Please try another product");
                }
            }
        }
        return changes;
    }
    public long getTotalSales(){
        return totalSales;
    }


    private boolean isFullPaid() {
        return currentBalance >= currentItem.getPrice();
    }

    @Override
    public void reset() {
        cashInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        currentItem = null;
        currentBalance = 0;
    }

}