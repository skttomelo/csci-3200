package problem5;

public class MyQueueTester {
	public static void main(String[] args){
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		System.out.println(queue.peek()); // outputs 1
		queue.dequeue(); // removes 1
		System.out.println(queue.peek()); // outputs 5
		queue.dequeue(); // remove 5
		System.out.println(queue.top()+"\n-----------"); // outputs 4
		queue.printStack();
	}
}
