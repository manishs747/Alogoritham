package data_structure.strings.online;


/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class AlienDictionary {


    public static void main(String[] args) {
        String order = "worldabcefghijkmnpqstuvxyz";
        String [] arr = {"word","world","row"};
        System.out.println(isAlienSorted(arr,order));
    }



    public static boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++){
            orderMap[order.charAt(i) - 'a'] = i;
        }
        for(int i=0;i< words.length-1;i++){
            if(!compareString(words[i],words[i+1],orderMap)){
                return false;
            }
        }
        return true;
    }

    public static boolean compareString(String w1,String w2,int[] orderMap){
        if(w1.length() > w2.length()){
          return false;
        }
        for(int i = 0;i < w1.length();i++){
            if (i >= w2.length()) return false;
            if(w1.charAt(i) == w2.charAt(i)){
                continue;
            }
            if(orderMap[w1.charAt(i)-'a'] > orderMap[w2.charAt(i)-'a']){
                return false;
            }
            break;
        }
        return true;
    }
}
