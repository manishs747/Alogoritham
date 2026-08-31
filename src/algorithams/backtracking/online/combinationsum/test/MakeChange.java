package algorithams.backtracking.online.combinationsum.test;

public class MakeChange {

    public static void main(String[] args) {
        int [] coins = {1,2,3};
        int amount = 3;
        System.out.println(makeChange(amount,0,coins));
    }


    public static int makeChange(int amount,int index ,int [] coins){
        if(amount==0) return 1;
        if(amount < 0 || index >= coins.length) return 0;
        int ways = 0;
        ways += makeChange(amount-coins[index],index,coins);
        ways += makeChange(amount,index+1,coins);
        return ways;
    }




}
