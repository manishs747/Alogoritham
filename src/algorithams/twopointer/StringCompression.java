package algorithams.twopointer;

public class StringCompression {

    public static void main(String[] args) {

        char [] chars = {'a','a','b','b','c','c','c'};;
        System.out.println(compress(chars));

    }

    public static int compress(char[] chars) {
        int write = 0 , count = 1;
        for (int i = 1; i <= chars.length ; i++) {
            if(i == chars.length || chars[i] != chars[i-1]){
               write = add(chars,write,chars[i-1],count);
               count= 1;
            } else{
                count++;
            }
        }
       return write;
    }

    public static int add(char[] chars , int start, char value , int count){
        chars[start++] = value;
        if(count == 1) return start;
        char[] digits = String.valueOf(count).toCharArray();
        for (char digit : digits){
            chars[start++] = digit;
        }
        return start;
    }


    public static int compress2(char[] chars) {
        int start = 0 , count = 1;
        char prev = chars[0] , cur = prev;
        for (int i = 1;i < chars.length ;i++){
            cur = chars[i];
            if(prev != cur ){
                start =  add(chars,start,prev,count);
                count = 1;
            }else{
                count++;
            }
            prev = cur;
        }
        start =  add(chars,start,cur,count);
        return start;
    }






}
