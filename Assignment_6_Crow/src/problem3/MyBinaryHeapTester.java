package problem3;

import java.util.Random;
import java.util.Scanner;

public class MyBinaryHeapTester {

	public static int findKthSmallest(Integer[] array, int k) {
		MyBinaryHeap<Integer> mbh = new MyBinaryHeap<>(array);
		for(int i = 0; i < k-1; i++) {
			mbh.deleteMin();
		}
		System.out.println("The heap looks like this "+mbh.toString()+"\n\nAnd this is what the "+k+"th smallest element is");
		return mbh.findMin();
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter what n will be:");
		int n = in.nextInt();
		Integer[] ints = new Integer[n];
		System.out.println("What is the k kth smallest)?");
		n = in.nextInt();
		for(int i = 0; i < ints.length; i++) {
			ints[i] = r.nextInt();
		}
		System.out.println(MyBinaryHeapTester.findKthSmallest(ints, n));
	}

}
