package problem3;

import java.util.Arrays;

public class MyBinaryHeap <E extends Comparable<? super E>> {
	private int defaultSize = 4;
	private int currentSize = 0;
	private E[] heap;

	public MyBinaryHeap()
	{
		heap = (E[])new Comparable[defaultSize];
	}
	public MyBinaryHeap(int size)
	{
		heap = (E[])new Comparable[this.nextSize(size)];
	}
	public MyBinaryHeap(E[] items)
	{
		heap = (E[])new Comparable[this.nextSize(items.length)];
		this.addAll(items);
	}

	public void addAll(E[] items)
	{
		//make sure there is room for all new items
		if(currentSize+items.length >= heap.length)
		{
			growArray(this.nextSize(currentSize+items.length));
		}

		for(E item : items)//copy new items in order
		{
			currentSize++;
			heap[currentSize] = item;
		}

		this.buildHeap();//fix heap order
	}
	private void buildHeap()
	{
		for(int i = currentSize >> 1; i > 0; i--)
		{
			percolateDown(i);
		}
	}

	public void insert(E val)
	{
		//make sure we have room for new item
		if(currentSize+1 >= heap.length)
		{
			growArray();
		}
		currentSize++;
		heap[0] = val;//temporary storage
		percolateUp(currentSize);
	}
	private void percolateUp(int pos)
	{
		//pos>>1 = pos/2 - getting to parent of empty space
		for(;heap[pos>>1].compareTo(heap[0]) > 0;pos = pos>>1)
		{
			heap[pos] = heap[pos>>1];//move parent down a level
		}
		heap[pos] = heap[0];//take value from initial insert and put in correct pos
	}

	public E findMin()
	{
		return (currentSize > 0)?heap[1]:null;
	}
	public E deleteMin()
	{
		if(currentSize > 0)
		{
			E temp = heap[1];

			heap[1] = heap[currentSize];//moved last value to top
			currentSize--;//decrease size
			percolateDown(1);//move top value down to final position

			return temp;
		}
		else
		{
			return null;//no items in heap
		}
	}
	private void percolateDown(int pos)
	{
		int firstChild = pos << 1;//pos * 2
		E temp = heap[pos];
		for(;pos<<1 <= currentSize; pos = firstChild, firstChild = pos<<1)
		{
			if(firstChild+1 <= currentSize)//there is a second child
			{
				if(heap[firstChild].compareTo(heap[firstChild+1]) > 0)
				{
					firstChild++;
				}
			}
			//firstChild is now the index of the smaller child
			if(temp.compareTo(heap[firstChild]) > 0)
			{
				heap[pos] = heap[firstChild];//move child up to parent and continue
			}
			else
			{
				break;//stop loop because we found correct position for temp
			}
		}
		heap[pos] = temp;
	}

	public String toString()
	{
		String output = "Heap Size:"+heap.length+"\n";
		for(int i = 1; i <= currentSize; i++)
		{
			output += heap[i]+",";
		}
		return output;
	}

	public boolean isEmpty()
	{
		return currentSize == 0;
	}
	public void makeEmpty()
	{
		currentSize = 0;
	}

	private void growArray()//O(N)
	{
		growArray(heap.length << 1);//heap.length * 2
	}
	private void growArray(int size)
	{
		//new array that is twice as big
		E[] newArr = (E[])new Comparable[size];
		//Move values to new array
		for(int i = 1; i <= currentSize; i++)//O(N)
		{
			newArr[i] = heap[i];
		}
		//System.out.println(Arrays.toString(newArr));
		heap = newArr;//replace small array with new one
	}
	private int nextSize(int size)
	{
		return 1 << (Integer.toBinaryString(size).length() + 1);
	}
	
	public E findKthSmallest(int target) {
		MyBinaryHeap a = this;
		for(int i = 0; i < target-1; i++) {
			a.deleteMin();
		}
		return (E) a.findMin();
	}
}
