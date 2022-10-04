package general;

import java.util.List;

public class CountItems {

    public static void main(String[] args) {

    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for(List<String> list:items){
            switch (ruleKey ){
                case "type":
                    count += list.get(0).equals(ruleValue) ? 1 : 0;
                    break;
                case "color":
                    count += list.get(1).equals(ruleValue) ? 1 : 0;
                    break;
                case "name":
                    count += list.get(2).equals(ruleValue) ? 1 : 0;
                    break;
            }
        }
        return count;
    }

    public static boolean match(String first , String second){

        return true;
    }
}
