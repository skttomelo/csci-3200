package problem4;

public class MyBinaryHeapTester {


	
	public static void main(String[] args) {

		MyBinaryHeap<Integer> mbh2 = new MyBinaryHeap<>(new Integer[]{9,8,7,6,5,4,3,2,1});
		System.out.println(mbh2);
		
		System.out.println(mbh2.findKthLargest(4));
	}

}
