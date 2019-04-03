package problem5;

import java.util.Arrays;

public class MyBinaryHeap <E extends Comparable<? super E>> {
	private int defaultSize = 4;
	private int currentSize = 0;
	private E[] heap;
	private int opCounter = 0;

	public MyBinaryHeap()
	{
		heap = (E[])new Comparable[defaultSize];
		opCounter++;
	}
	public MyBinaryHeap(int size)
	{
		heap = (E[])new Comparable[this.nextSize(size)];
		opCounter++;
	}
	public MyBinaryHeap(E[] items)
	{
		heap = (E[])new Comparable[this.nextSize(items.length)];
		opCounter+=2;
		this.addAll(items);
	}

	public void addAll(E[] items)
	{
		//make sure there is room for all new items
		opCounter++;
		if(currentSize+items.length >= heap.length)
		{
			opCounter++;
			growArray(this.nextSize(currentSize+items.length));
		}
		opCounter++;
		for(E item : items)//copy new items in order
		{
			opCounter+=2;
			currentSize++;
			opCounter++;
			heap[currentSize] = item;
			opCounter++;
		}
		opCounter++;
		this.buildHeap();//fix heap order
	}
	private void buildHeap()
	{
		opCounter+=3;
		for(int i = currentSize >> 1; i > 0; i--)
		{
			opCounter++;
			percolateDown(i);
			opCounter+=3;
		}
	}

	public void insert(E val)
	{
		opCounter+=2;
		//make sure we have room for new item
		if(currentSize+1 >= heap.length)
		{
			opCounter++;
			growArray();
		}
		opCounter+=4;
		currentSize++;
		heap[0] = val;//temporary storage
		percolateUp(currentSize);
	}
	private void percolateUp(int pos)
	{
		opCounter+=3;
		//pos>>1 = pos/2 - getting to parent of empty space
		for(;heap[pos>>1].compareTo(heap[0]) > 0;pos = pos>>1)
		{
			opCounter+=2;
			heap[pos] = heap[pos>>1];//move parent down a level
			opCounter+=5;
		}
		opCounter++;
		heap[pos] = heap[0];//take value from initial insert and put in correct pos
	}

	public E findMin()
	{
		opCounter+=3;
		return (currentSize > 0)?heap[1]:null;
	}
	public E deleteMin()
	{
		opCounter++;
		if(currentSize > 0)
		{
			opCounter++;
			E temp = heap[1];
			
			opCounter+=5;
			heap[1] = heap[currentSize];//moved last value to top
			currentSize--;//decrease size
			percolateDown(1);//move top value down to final position

			return temp;
		}
		else
		{
			opCounter++;
			return null;//no items in heap
		}
	}
	private void percolateDown(int pos)
	{
		opCounter+=3;
		int firstChild = pos << 1;//pos * 2
		E temp = heap[pos];
		opCounter+=2;
		//TODO continue adding operation counts//
		for(;pos<<1 <= currentSize; pos = firstChild, firstChild = pos<<1)
		{
			opCounter+=2;
			if(firstChild+1 <= currentSize)//there is a second child
			{
				opCounter+=3;
				if(heap[firstChild].compareTo(heap[firstChild+1]) > 0)
				{
					opCounter+=2;
					firstChild++;
				}
			}
			opCounter+=2;
			//firstChild is now the index of the smaller child
			if(temp.compareTo(heap[firstChild]) > 0)
			{
				opCounter++;
				heap[pos] = heap[firstChild];//move child up to parent and continue
			}
			else
			{
				opCounter++;
				break;//stop loop because we found correct position for temp
			}
			opCounter+=5;
		}
		opCounter++;
		heap[pos] = temp;
	}

	public String toString()
	{
		opCounter++;
		String output = "Heap Size:"+heap.length+"\n";
		opCounter+=2;
		for(int i = 1; i <= currentSize; i++)
		{
			opCounter+=3;
			output += heap[i]+",";
			opCounter+=3;
		}
		opCounter++;
		return output;
	}

	public boolean isEmpty()
	{
		opCounter+=2;
		return currentSize == 0;
	}
	public void makeEmpty()
	{
		opCounter++;
		currentSize = 0;
	}

	private void growArray()//O(N)
	{
		opCounter+=2;
		growArray(heap.length << 1);//heap.length * 2
	}
	private void growArray(int size)
	{
		opCounter+=2;
		//new array that is twice as big
		E[] newArr = (E[])new Comparable[size];
		opCounter+=2;
		//Move values to new array
		for(int i = 1; i <= currentSize; i++)//O(N)
		{
			opCounter++;
			newArr[i] = heap[i];
			opCounter+=3;
		}
		//System.out.println(Arrays.toString(newArr));
		heap = newArr;//replace small array with new one
	}
	private int nextSize(int size)
	{
		opCounter+=5;
		return 1 << (Integer.toBinaryString(size).length() + 1);
	}
	public int getOperationCounts() {
		return opCounter;
	}
}
