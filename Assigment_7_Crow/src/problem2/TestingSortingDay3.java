package problem2;

import java.util.Arrays;
import java.util.Random;

public class TestingSortingDay3 {

	public static void main(String[] args) {
		Integer[] insertTest = new Integer[]{81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
		Integer[] shellTest = insertTest.clone();
		Integer[] heapTest = insertTest.clone();
		Integer[] mergeTest = insertTest.clone();
		Integer[] quickTest = insertTest.clone();

		/** /
		System.out.println("Before Insertion Sort");
		System.out.println(Arrays.toString(insertTest));
		System.out.println("Inversion count: " + SortingMethodsDay3.inversionCounter(insertTest));
		SortingMethodsDay3.insertionSort(insertTest);
		System.out.println("After Insertion Sort");
		System.out.println(Arrays.toString(insertTest));
		System.out.println("\n");
		/** /
		System.out.println("Before Shell Sort");
		System.out.println(Arrays.toString(shellTest));
		System.out.println("Inversion count: " + SortingMethodsDay3.inversionCounter(shellTest));
		SortingMethodsDay3.shellSort(shellTest);
		System.out.println("After Shell Sort");
		System.out.println(Arrays.toString(shellTest));
		System.out.println("\n");
		/** /
		System.out.println("Before Heap Sort");
		System.out.println(Arrays.toString(heapTest));
		System.out.println("Inversion count: " + SortingMethodsDay3.inversionCounter(heapTest));
		SortingMethodsDay3.heapSort(heapTest);
		System.out.println("After Heap Sort");
		System.out.println(Arrays.toString(heapTest));
		System.out.println("\n");
		/** /
		System.out.println("Before Merge Sort");
		System.out.println(Arrays.toString(mergeTest));
		System.out.println("Inversion count: " + SortingMethodsDay3.inversionCounter(mergeTest));
		SortingMethodsDay3.mergeSort(mergeTest);
		System.out.println("After Merge Sort");
		System.out.println(Arrays.toString(mergeTest));
		System.out.println("\n");
		/** /
		System.out.println("Before Quick Sort");
		System.out.println(Arrays.toString(quickTest));
		System.out.println("Inversion count: " + SortingMethodsDay3.inversionCounter(quickTest));
		SortingMethodsDay3.quickSort(quickTest);
		System.out.println("After Quick Sort");
		System.out.println(Arrays.toString(quickTest));
		System.out.println("\n");
		/** /
		Integer[] bucketTest = new Integer[10000];
		Random r = new Random();
		for(int i = 0; i < bucketTest.length; i++)
		{
			bucketTest[i] = r.nextInt(71)+15;
		}
		System.out.println("Before Bucket Sort");
		System.out.println(Arrays.toString(bucketTest));
		SortingMethodsDay3.bucketSort(bucketTest, 15, 85);
		System.out.println("After Bucket Sort");
		System.out.println(Arrays.toString(bucketTest));
		System.out.println("\n");
		/**/
		String[] radixTest = new String[]{
				"abc","cda","afg","zzz","aaa",
				"9f7","123","1z1","988","5a7", "5a1", "1234"};
		System.out.println("Before Radix Sort");
		System.out.println(Arrays.toString(radixTest));
		SortingMethodsDay3.radixSortStrings(radixTest);
		System.out.println("After Radix Sort");
		System.out.println(Arrays.toString(radixTest));
		System.out.println("\n");

	}

}
