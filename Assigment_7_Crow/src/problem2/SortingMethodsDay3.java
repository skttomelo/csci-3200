package problem2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * public static methods prevents needing to create an object of this class to use the methods
 */
public class SortingMethodsDay3 {

	/*
	 * Big-O : O(N^2) = O(I+N) where I is number of inversions (value is up to N^2)
	 * Best case (list already in order): O(N)
	 * Worst case (list in reverse order): O(N^2)
	 */
	public static <E extends Comparable<? super E>> void insertionSort(E[] arr)
	{
		/*
		 * Consider array as 2 parts
		 * Part 1: Sorted
		 * Part 2: Unsorted
		 * Initially, Part 1 is just position zero
		 * Take one item from Part 2 and put it into the correct position in Part 1
		 * 	Move values as needed
		 */

		//initial "hole" or where we are moving an item from
		int hole = 1;
		int moveCount = 0;
		//loop from 2nd item to last, first is already sorted
		for(int i = 1; i < arr.length; i++)
		{
			//temp storage for item in current position
			E temp = arr[i];
			//loop from hole (current position) while hole is > 0 and temp < hole-1
			for(hole = i; hole > 0 && temp.compareTo(arr[hole-1]) < 0; hole--)
			{
				//move value from hole-1 to hole
				arr[hole] = arr[hole-1];//move larger value one space to the right
				moveCount++;
			}
			//put temp into final hole location
			arr[hole] = temp;
		}
		System.out.println("Number of moves performed:"+moveCount);
	}

	/*
	 * Big-O : O(N^(3/2))
	 */
	public static <E extends Comparable<? super E>> void shellSort(E[] arr)
	{
		/*
		 * Consider array as several layers of sub lists
		 * Each pass of the method has a different number of sub lists
		 * First pass has the most sub lists, last pass treats the array as a single list
		 * Sub lists are determined by a "shell" number
		 * 		For example, if the shell number is 5, that means every 5th number is part of a single sub list
		 * 			Item 0, 5, 10 are in one list, 1, 6, 11 are in another, etc
		 * These sub lists are then sorted similar to insertion sort
		 * Next shell number is determined and new sub lists are created and sorted
		 * Final step uses shell number 1 and just performs an insertion sort
		 */

		//initial "hole" or where we are moving an item from
		int hole = 1;
		int moveCount = 0;
		int moveThisShell = 0;
		//loop through shell numbers starting at length/2, going down by shell/2 at a time
		for(int shell = arr.length/2; shell > 0; shell /= 2)
		{
			//loop through sublists, set first sublist = to shell number, increment by 1 to length of array
			for(int sublist = shell; sublist < arr.length; sublist++)
			{
				//temp storage for item in current sublist position
				E temp = arr[sublist];
				//loop from hole = sublist while hole is >= shell and temp < hole-shell, decrease hole by shell
				for(hole = sublist; hole >= shell && temp.compareTo(arr[hole-shell]) < 0; hole -= shell)
				{
					//move hole-shell to hole
					arr[hole] = arr[hole-shell];
					moveCount++;
					moveThisShell++;
				}
				//put temp into hole
				arr[hole] = temp;
			}
			//System.out.println("Inversions after shell size "+shell+": "+SortingMethods.inversionCounter(arr));
			//System.out.println("Moves performed this shell: "+moveThisShell);
			//System.out.println(Arrays.toString(arr));
			moveThisShell = 0;
		}
		System.out.println("Number of moves performed:"+moveCount);
	}

	/*
	 * Big-O : O(N log N)
	 */
	public static <E extends Comparable<? super E>> void heapSort(E[] arr)
	{
		/*
		 * Insert items into heap
		 * Remove items from heap (in sorted order)
		 */

		//create heap/priority queue
		PriorityQueue<E> heap = new PriorityQueue<>();
		//add all items to heap
		heap.addAll(Arrays.asList(arr));
		//loop until heap is empty
		for(int i = 0; i < arr.length; i++)
		{
			//put each deleteMin into original array
			arr[i] = heap.remove();
		}
	}

	public static <E extends Comparable<? super E>> void mergeSort(E[] arr)
	{
		//call mergeSort(arr, temp[], 0, length-1)
		mergeSort(arr, (E[])new Comparable[arr.length], 0, arr.length-1);
	}
	public static <E extends Comparable<? super E>> void mergeSort(
			E[] arr, E[] temp, int left, int right)
	{
		//if left < right
		if(left < right)
		{
			//find center
			int center = left+((right-left)/2);
			//System.out.println("Left:"+left+" : Center:"+center+" : Right:"+right);
			//call mergeSort on left half (left, center)
			mergeSort(arr, temp, left, center);
			//call mergeSort on right half (center+1, right)
			mergeSort(arr, temp, center+1, right);
			//call merge over left/right halves
			//System.out.println("Merge from "+left+" to "+right);
			merge(arr, temp, left, center+1, right);
			//System.out.println(Arrays.toString(arr));
		}
	}
	public static <E extends Comparable<? super E>> void merge(
			E[] arr, E[] temp, int leftStart, int rightStart, int rightEnd)
	{
		//determine leftEnd
		int leftEnd = rightStart - 1;
		//set temp array position (same as left start)
		int tempPos = leftStart;
		//determine number of elements (end - start + 1)
		int numItems = rightEnd - leftStart + 1;
		//while items remain in both lists
		while(leftStart <= leftEnd && rightStart <= rightEnd)
		{
			//put smaller into temp array, move pointers forward
			if(arr[leftStart].compareTo(arr[rightStart]) < 0)//left side smaller
			{
				temp[tempPos] = arr[leftStart];
				tempPos++;
				leftStart++;
			}
			else
			{
				temp[tempPos] = arr[rightStart];
				tempPos++;
				rightStart++;
			}
			//move temp position forward
		}
		//while items remain in left list
		while(leftStart <= leftEnd)
		{
			//add remaining items to end of temp
			temp[tempPos] = arr[leftStart];
			tempPos++;
			leftStart++;
		}
		//while items remain in right list
		while(rightStart <= rightEnd)
		{
			//add remaining items to end of temp
			temp[tempPos] = arr[rightStart];
			tempPos++;
			rightStart++;
		}
		//copy from temp to original using number of items and rightEnd
		for(;numItems > 0; numItems--, rightEnd--)
		{
			arr[rightEnd] = temp[rightEnd];
		}
	}

	public static <E extends Comparable<? super E>> void quickSort(E[] list)
	{
		//convert array to a list
		List<E> tempList = new LinkedList<>(Arrays.asList(list));
		//run quicksort on list
		quickSort(tempList);
		//convert list back to array
		int pos = 0;
		for(E i : tempList)
		{
			list[pos] = i;
			pos++;
		}
	}
	public static <E extends Comparable<? super E>> void quickSort(List<E> list)
	{
		//if list has more than 1 item
		if(list.size() > 1)
		{
			//create 3 lists (smaller, same/equal, larger)
			List<E> smaller = new LinkedList<>();
			List<E> equal = new LinkedList<>();
			List<E> larger = new LinkedList<>();
			//pick item for middle/pivot
			E first = list.get(0);
			E last = list.get(list.size()-1);
			E middle = list.get(list.size()/2);
			E pivot;
			if(first.compareTo(last) > 0)//first larger than last
			{
				if(first.compareTo(middle) > 0)//first larger than last and middle
				{
					if(last.compareTo(middle) > 0)//last larger than middle
					{
						pivot = last;
					}
					else
					{
						pivot = middle;
					}
				}
				else
				{
					pivot = first;
				}
			}
			else//first smaller than last
			{
				if(first.compareTo(middle) < 0)//first smaller than last and middle
				{
					if(last.compareTo(middle) > 0)//last larger than middle
					{
						pivot = middle;
					}
					else
					{
						pivot = last;
					}
				}
				else
				{
					pivot = first;
				}

			}
			//loop through list, putting items into correct containers
			for(E item : list)
			{
				int compare = item.compareTo(pivot);
				if(compare == 0)//same/equal
				{
					equal.add(item);
				}
				else if(compare > 0)//greater
				{
					larger.add(item);
				}
				else
				{
					smaller.add(item);
				}
			}
			//quicksort smaller/larger
			System.out.println("Pivot:"+pivot+" : Smaller:"+smaller.size()+" : Larger:"+larger.size());
			quickSort(smaller);
			quickSort(larger);

			//put items back into original list in correct order (clear, addAll)
			list.clear();
			list.addAll(smaller);
			list.addAll(equal);
			list.addAll(larger);
		}
	}

	public static <E extends Comparable<? super E>> int inversionCounter(E[] arr)
	{
		int inversioncount = 0;
		for(int i = 0; i < arr.length; i++)//check each value
		{
			for(int j = i+1; j < arr.length; j++)//check all values to the right
			{
				if(arr[i].compareTo(arr[j]) > 0)//value to the right is larger
					inversioncount++;
			}
		}
		return inversioncount;
	}

	public static void bucketSort(Integer[] arr, int min, int max)
	{
		//number of buckets
		int bucketCount = max - min + 1;
		//create buckets for range
		int[] buckets = new int[bucketCount];
		//add each item from array to correct bucket counter (shift if needed)
		for(Integer item : arr)//O(N)
		{
			//-min to shift into correct index range
			buckets[item-min]++;
		}
		int pos = 0;
		//run through buckets to refill array in correct order (shift back if needed)
		for(int i = 0; i < buckets.length; i++)
		{
			//put the number of identical items back into the array
			for(int j = 0; j < buckets[i]; j++, pos++)
			{
				//+min is to shift back into correct range
				arr[pos] = i+min;
			}
		}
	}

	public static void radixSortStrings(String[] arr, int stringLen)
	{
		//number of buckets = 256 (characters in the character set)
		int bucketCount = 256;
		//if you were doing a case insensitive sort, and you knew everything was single words, you could use 26 as your size

		//Buckets need to be lists instead of counters
		List<String>[] buckets = new LinkedList[bucketCount];
		//create array of lists and initialize each object
		for(int i = 0; i < buckets.length; i++)
		{
			buckets[i] = new LinkedList<>();
		}

		//loop from end of string to beginning
		for(int strpos = stringLen-1; strpos >= 0; strpos--)
		{
			//loop through each string
			for(String item : arr)
			{
				//add to appropriate bucket
				buckets[item.charAt(strpos)].add(item);
				//item.charAt(strpos) converts to int automatically
				//A = 65, a = 97, 0 = 48, space = 32
			}
			//pointer for position in original list
			int pos = 0;
			//loop through buckets
			for(int i = 0; i < buckets.length; i++)
			{
				//loop through items in each buck
				for(String item : buckets[i])
				{
					//add each string back to original array in new order
					arr[pos] = item;
					pos++;
				}
				//clear the bucket
				buckets[i].clear();//O(1)
			}
			System.out.println("Sorted on "+strpos+" : "+Arrays.toString(arr));
		}
	}

	//Homework 2 - Complete the radixSortStrings method without all strings in the array being the same size
	public static void radixSortStrings(String[] arr)
	{
		//use same length as a starting point, very little should need to be changed
		//DO NOT use the version in the textbook, modify the same length to work for different length
		//DO NOT create any additional arrays/data structures variables
		//changing the number of buckets is allowed
		//number of buckets = 256 (characters in the character set)
		int bucketCount = 256;
		//if you were doing a case insensitive sort, and you knew everything was single words, you could use 26 as your size

		//Buckets need to be lists instead of counters
		List<String>[] buckets = new LinkedList[bucketCount];
		//create array of lists and initialize each object
		for(int i = 0; i < buckets.length; i++)
		{
			buckets[i] = new LinkedList<>();
		}

		int stringLen = arr[0].length();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length() > stringLen) {
				stringLen = arr[i].length();
			}
		}
		
		//loop from end of string to beginning
		for(int strpos = stringLen-1; strpos >= 0; strpos--)
		{
			//loop through each string
			for(String item : arr)
			{
				//add to appropriate bucket
				try {
					buckets[item.charAt(strpos)].add(item);
				}catch(Exception e) { // if strpos is less than or equal to the item length - 1 then we need to catch that
					buckets[0].add(item);
				}
				//item.charAt(strpos) converts to int automatically
				//A = 65, a = 97, 0 = 48, space = 32
			}
			//pointer for position in original list
			int pos = 0;
			//loop through buckets
			for(int i = 0; i < buckets.length; i++)
			{
				//loop through items in each buck
				for(String item : buckets[i])
				{
					//add each string back to original array in new order
					arr[pos] = item;
					pos++;
				}
				//clear the bucket
				buckets[i].clear();//O(1)
			}
			System.out.println("Sorted on "+strpos+" : "+Arrays.toString(arr));
		}
	}

}
