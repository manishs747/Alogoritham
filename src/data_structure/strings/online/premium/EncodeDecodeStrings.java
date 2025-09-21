package data_structure.strings.online.premium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {

    public static void main(String[] args) {
        String [] Input = {""};

        System.out.println(encode(Arrays.asList(Input)));
        System.out.println(decode(encode(Arrays.asList(Input))));


    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str:strs) {
            sb.append(str).append("/:");
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        if(str.isEmpty()) return new ArrayList<>();
        if(str.equals("/:")) return Arrays.asList("");
        String[] strs = str.split("/:");
        return Arrays.asList(strs);
    }
}
