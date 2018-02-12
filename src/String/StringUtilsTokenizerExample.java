package String;





import opennlp.tools.tokenize.SimpleTokenizer;

public class StringUtilsTokenizerExample {

	public static void main(String[] args) {
		
       
		
		 String word = null ;
		      
		
		 //Instantiating SimpleTokenizer class 
	     
	      SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;
	      String[] sentences = simpleTokenizer.tokenize(word);
		
		for (String str : sentences) {
			System.out.println(str);
		}
		

	}

}
