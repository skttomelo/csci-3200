package problem4;

import java.util.Random;
import java.util.Scanner;

public class MyBinaryHeapTester {

	public static int findKthLargest(Integer[] array, int k) {
		Integer[] s = new Integer[k];
		for(int i = 0; i < k; i++) {
			s[i] = array[i];
		}
		MyBinaryHeap<Integer> mbh = new MyBinaryHeap<>(s);
		for(int i = k; i < array.length; i++) {
			if(array[i] > mbh.findMin()) {
				mbh.deleteMin();
				mbh.insert(array[i]);
			}
		}
		System.out.println("The heap looks like this "+mbh.toString()+"\n\nAnd this is what the "+k+"th largest element is");
		return mbh.findMin();
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter what n will be:");
		int n = in.nextInt();
		Integer[] ints = new Integer[n];
		System.out.println("What is the k (kth largest)?");
		n = in.nextInt();
		for(int i = 0; i < ints.length; i++) {
			ints[i] = r.nextInt();
		}
		System.out.println(MyBinaryHeapTester.findKthLargest(ints, n));
	}

}
