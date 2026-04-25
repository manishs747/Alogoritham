package algorithams.backtracking.online.permuation;

public class PermutationNew {

    public static void main(String[] args) {
        String [] str = new String [] {"A","B","C"};
        permute(str,0,"");

    }



    public static void permute(String[] str ,int start, String path) {
        System.out.println(path);
        if(str.length == start) {return;}
        for(int i=start;i<str.length;i++) {
            path += str[i];
            permute(str,start+1,path);
            path=path.substring(0,i);
        }


    }

}
