package problem5;

public class MyQueue<E> {
	private Node start, end;
	private int currentCount;
	public MyQueue(){
		start = null;
		end = null;
		currentCount = 0;
	}
	public void printStack(){ //available for testing, not O(1)
		Node current = start;
		while(current != null){
			System.out.println(current.value);
			current = current.next;
		}
	}
	public void enqueue(E val){ //O(1)
		Node newItem = new Node(val);
		Node previousEnd = end;
		end = newItem;
		
		//if list is empty
		if(start == null){
			start = end;
		}else{
			previousEnd.next = end;
		}
		currentCount++;
	}
	public E dequeue(){ //O(1)
		if(start == null){ //empty stack
			return null;
		}else{
			E val = start.value;
			start = start.next;
			currentCount--;
			return val;
		}
	}
	public E peek(){ //O(1)
		if(start == null){ //empty stack
			return null;
		}else{
			E val = start.value;
			return val;
		}
	}
	public int size(){ //O(1)
		return currentCount;
	}
	private class Node{
		E value;
		Node next;
		public Node(E v){
			value = v;
			next = null;//no node after this one
		}
	}
}
