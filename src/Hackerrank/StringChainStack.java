package Hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringChainStack {

	public static void main(String[] args) {
		
		String[] words = {"a", "b", "ca", "bca", "bda", "bdca"};
		//String[] words = {"a", "b","ba"};
		int longestChain = longestChain(words);
		System.out.println("longestChain " + longestChain);

	}
	
	static int longestChain(String words[]) {
		List<String> wordList = Arrays.asList(words);
		int max = Integer.MIN_VALUE;
		for (String word : words) {
			int current = processWord(word, wordList);
			if (max < current) {
				max = current;
			}
			System.out.println(current);
		}
		return max;
	}
	
	static int processWord(String word, List<String> allWords) {
		System.out.println("PROCESSING "+word);
		if (word.length() == 1)
			return 1;

		Stack<String> wordsStack = new Stack<String>();
		wordsStack.add(word);

		// start and end indices which hold character is dropped from the current word
		int startIndex = 0;
		int endIndex = 1;

		while (!wordsStack.isEmpty()) {
			String currentWord = wordsStack.peek();
			System.out.println("CURRENT WORD:"+currentWord+" ST:"+startIndex +" END:"+endIndex);

			if (endIndex > currentWord.length()) {
				if(!allWords.contains(wordsStack.peek())){
					wordsStack.pop();
				}
				break;
			}

			if (allWords.contains(currentWord)) {
				StringBuilder wordBuilder = new StringBuilder(currentWord);
				System.out.println("Remove "+wordBuilder.substring(startIndex, endIndex)+" from word:"+currentWord+" "+word);
				wordBuilder.delete(startIndex, endIndex);
				wordsStack.add(wordBuilder.toString());
				System.out.println("Length of Stack:"+wordsStack.size());
				//System.out.print(" st "+wordsStack);
			} else {
				System.out.println(" Removing from Stack:"+wordsStack.peek());
				wordsStack.pop();
				startIndex++;
				endIndex++;
			}
			System.out.println();
		}
        System.out.println("Chain Size FOR WORD "+word+" is "+wordsStack.size());
        System.out.println(wordsStack);
        System.out.println();
        System.out.println();
		return wordsStack.size();
	}
	
	
	

}
