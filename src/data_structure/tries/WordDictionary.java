package data_structure.tries;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
public class WordDictionary {

    public class TrieNode {
        TrieNode[] children;
        boolean word;
        public TrieNode() {
            children = new TrieNode[26];
            word = false;
        }
    }

    public static void main(String[] args) {

        WordDictionary wd = new WordDictionary();
        wd.addWord("abc");
        wd.addWord("abd");
        System.out.println(wd.search("a.e"));

    }

    private TrieNode root;


    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
       TrieNode cur = root;
       for(char c: word.toCharArray()){
           if(cur.children[c-'a'] == null ){
               cur.children[c-'a'] = new TrieNode();
           }
           cur = cur.children[c-'a'];
       }
      cur.word = true;
    }

    public boolean search(String word) {

        return dfs(word,0,root);
    }

    private boolean dfs(String word, int index, TrieNode root) {
        if(root == null || index > word.length())  return false;
        if(index == word.length()) return root.word  ;
        char c = word.charAt(index);
        if(c == '.'){
            for(TrieNode curNode : root.children){
                if(curNode == null) continue;
                if(dfs(word,index+1,curNode)){
                    return true;
                }
            }
        }else{
           TrieNode child = root.children[c-'a'];
           if(child == null) return false;
           return dfs(word,index+1,child);
        }
       return  false;
    }
}
