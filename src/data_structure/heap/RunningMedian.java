package data_structure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*

 
 
 https://www.youtube.com/watch?v=VmogG01IjYc
 https://www.hackerrank.com/challenges/find-the-running-median/problem
 
 * 
 * 
 * 
 */
public class RunningMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr [] = new int [n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		double[] median = getMedians(arr);
		for (double d : median) {
			System.out.println(d);
		}
	}
	
	
	public static double[] getMedians(int [] arr){
		//max data_structure.heap
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
					public int compare(Integer a, Integer b) {
						return -1*a.compareTo(b);}}
				);
		PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
		double median [] = new double [arr.length];
		for (int i = 0; i < arr.length; i++) {
			int number = arr[i];
			addNumber(number,lowers,highers);
			rebalance(lowers,highers);
			median[i] = getMedian(lowers,highers);
		}
		return median;
	}
	
	private static double getMedian(PriorityQueue<Integer> lowers,
			PriorityQueue<Integer> highers) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> bigger = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smaller = lowers.size() > highers.size() ? highers : lowers;
		if(bigger.size() == smaller.size()){
			return (bigger.peek()+smaller.peek())/2.0;
		}else{
			return bigger.peek();
		}
		
	}


	private static void addNumber(int number, PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers) {
		if(lowers.size() == 0 || number < lowers.peek()){
			lowers.add(number);
		}else{
			highers.add(number);
		}
	}


	private static void rebalance(PriorityQueue<Integer> lowers,
			PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> bigger = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smaller = lowers.size() > highers.size() ? highers : lowers;
		//System.out.println("lowerSize "+lowers.size()+" highers:"+highers.size());
		if(bigger.size() - smaller.size() > 1){
			smaller.add(bigger.poll());
		}
			
	}


	

}
