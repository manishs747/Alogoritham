package data_structure.strings.online;

public class test {

    public static void main(String[] args) {
       String s = "wz???a??n";
       // wzabaaban
       //"wzacbacan"

        System.out.println(modifyString(s));
    }

    public  static String modifyString(String s) {
        char[] result = new char[s.length()];
        char prev = '?';;
        for (int i =0;i< s.length();i++) {
            result[i] = s.charAt(i);
            if( result[i] == '?'){
               char  next = i < s.length()-1?s.charAt(i+1):'?';
                result[i] =next(prev,next);

            }
          prev =  result[i];
        }
        return new String(result);
    }


    public static char next(char prev,char next){
         if (prev != 'a' && next != 'a'){
             return 'a';
         }
         if ((char) prev+1 == next){
            return  (char) (prev+2);
         }
         return (char) (prev+1);
    }
}
