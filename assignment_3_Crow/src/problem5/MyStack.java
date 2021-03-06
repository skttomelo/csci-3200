package problem5;

public class MyStack<E> {
	private Node start;
	private int currentCount;
	public MyStack()
	{
		start = null;
		currentCount = 0;
	}
	public void printStack()//available for testing, not O(1)
	{
		Node current = start;
		while(current != null)
		{
			System.out.println(current.value);
			current = current.next;
		}
	}
	public void push(E val)//O(1)
	{
		Node newItem = new Node(val);

		//if list is empty
		if(start == null)
		{
			start = newItem;
		}
		else
		{
			newItem.next = start;
			start = newItem;
		}
		currentCount++;
	}
	public E pop()//O(1)
	{
		if(start == null)//empty stack
		{
			return null;
		}
		else
		{
			E val = start.value;
			start = start.next;
			currentCount--;
			return val;
		}
	}
	public E top()//O(1)
	{
		if(start == null)//empty stack
		{
			return null;
		}
		else
		{
			E val = start.value;
			return val;
		}
	}
	public int size()//O(1)
	{
		return currentCount;
	}

	private class Node
	{
		E value;
		Node next;
		public Node(E v)
		{
			value = v;
			next = null;//no node after this one
		}
	}
}
