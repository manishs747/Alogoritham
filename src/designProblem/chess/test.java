package designProblem.chess;

import java.util.ArrayList;
import java.util.List;

//https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles
public class test {

	
	public static void main(String[] args) {
		
		int n = 4;
		int [] grades = {73,67,38,33};
		
		for (int i = 0; i < n; i++) {
            System.out.println(solve(grades[i]));
        }
		
	}
	
	public static int solve(int mark) {
		if (mark < 38) {
			return mark;
		}
		int diff = 5 - (mark % 5);
		if (diff < 3) {
			mark = mark + diff;
		}
		return mark;
	}
	
	
	
	

}
