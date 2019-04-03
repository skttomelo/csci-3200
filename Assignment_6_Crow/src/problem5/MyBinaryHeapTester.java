package problem5;

import java.util.Random;
import java.util.Scanner;

public class MyBinaryHeapTester {
	static Random r = new Random();
	static long start, stop;
	private static void startTime() {
		start = System.nanoTime();
	}
	private static String endTime() {
		stop = System.nanoTime();
		return String.format( "%12.6f",((stop-start)/Math.pow(10,9)));
	}
	public static void setArray(int n) {
		Integer[] array = new Integer[n];
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt();
		}
		startTime();
		MyBinaryHeap<Integer> mbh1 = new MyBinaryHeap<>(array); // for buildheap
		System.out.println("N = "+n);
		System.out.println("Runtime for using build heap:"+endTime());
		System.out.println("Build heap had a total operation count of "+mbh1.getOperationCounts());
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		startTime();
		MyBinaryHeap<Integer> mbh2 = new MyBinaryHeap<>(); // for individual inserts
		for(int i = 0; i < array.length; i++) {
			mbh2.insert(array[i]);
		}
		System.out.println("Runtime using individual inserts:"+endTime());
		System.out.println("Individual inserts had a total operation count of "+mbh2.getOperationCounts());
		System.out.println("\n");
	}
	public static void main(String[] args) {
		int[] nSizes = {25, 50, 75, 100, 200, 300, 400, 500, 1000, 10000};
		for(int i = 0; i < nSizes.length; i++) {
			setArray(nSizes[i]);
		}
	}

}
