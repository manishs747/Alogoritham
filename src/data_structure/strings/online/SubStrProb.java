package data_structure.strings.online;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubStrProb {

    public static void main(String[] args) {

        String[] word = {"mass", "as", "hero", "superhero"};
        System.out.println(stringMatching(word));
    }


    public static List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) {
            if (result.contains(words[i])) {
                continue;
            }
            for (int j = i + 1; j < words.length; j++) {
                String s = words[i];
                String l = words[j];
                if (s.length() > l.length()) {
                    s = words[j];
                    l = words[i];
                }
                if (l.contains(s)) {
                    result.add(s);
                }
            }
        }
        return result.stream().collect(Collectors.toList());
    }
}
