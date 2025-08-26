package algorithams.backtracking.online.wordsearch;



import java.util.*;


/**
 * https://leetcode.com/problems/word-search-ii/description/
 */
public class WordSearch2 {

    public static void main(String[] args) {

       char [][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
       String [] words = {"oa","oaa"};
       /* char [][] board = {{'a'}};
        String [] words = {"a"};*/
        WordSearch2 ws2 = new WordSearch2();
        System.out.println(ws2.findWords(board,words));

    }


    public  List<String> findWords(char[][] board, String[] words) {
        TrieNode wordsTire = new TrieNode();
        addWordToTrie(words,wordsTire);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                exist(i, j, board, wordsTire, result);
            }
        }
        return new ArrayList<>(result);
    }

    public  void exist(int row,int col , char[][] board, TrieNode parent , List<String> result ) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '#' || parent == null ||!parent.children.containsKey(board[row][col])) return ;
        TrieNode currNode = parent.children.get(board[row][col]);
        char letter = board[row][col];
        if(currNode.word != null){
            result.add(currNode.word);
            currNode.word = null;
        }
        board[row][col] = '#' ;
        int [][] paths = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int [] path:paths)
            exist(row+path[0],col+path[1],board,currNode,result);
        board[row][col] = letter;
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }

    private  void addWordToTrie(String[] words, TrieNode root) {
        for (String word : words) {
            TrieNode node = root;
            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word; // store words in Trie
        }
    }



    public class TrieNode {
        public Map<Character,TrieNode> children ;
        String word ;

        public TrieNode(){
            children = new HashMap<>();
        }

    }




}
