package Nicholas;
import java.util.Arrays;
import java.util.Random;

public class problem1 {

	/*
	 * Nicholas Poole
	 * 
	 * Assignment:
	 * 		Write a program to solve the selection problem. Find the Kth largest number in a series of random numbers, where K = N/2 
	 * 		and N is the amount of numbers. So, for 10 numbers, find the 5th largest. Add the code we went over in class to capture 
	 * 		run time in seconds for your solution. Set up your program to run four times with the following sizes of 
	 * 		N (10, 100, 1000, 10000). Plot the four run times in an excel chart. Run additional factors of 10 up from the above 
	 * 		numbers until your solution takes at least 1 second to finish and include all of these on the chart.
	 * 
	 * Grading:
	 * 		- Generate N random numbers (1pt)
	 * 		- Find the middle largest number (1pt)
	 * 		- Capture the run time of your solution (1pt) - Note, the time starts after you have filled the array with random numbers
	 * 		- Chart with run times for solution until solution takes 1second to complete (1pt)
	 * 
	 */
	
	public static void main(String[] args) {
		System.out.println("If N = 10, K will be " + findKthLargestNumber(10) + " seconds to process."); 		
	 	System.out.println("If N = 100, K will be " + findKthLargestNumber(100) + " seconds to process."); 		
	 	System.out.println("If N = 1000, K will be " + findKthLargestNumber(1000) + " seconds to process."); 		
	 	System.out.println("If N = 10000, K will be " + findKthLargestNumber(10000) + " seconds to process."); 	
	}

	public static String findKthLargestNumber(int N) {
		
	    //initializes Random
	    Random random = new Random();
	    
	    //initializes array for integers
	    int[] randomNumbers = new int[N];
	    
	    //populates the array with random integer values
	    for(int i = 0; i < N; i++){
	      randomNumbers[i] = random.nextInt();
	    }
			
	    //Timer starts
	    long start = System.nanoTime();
	    
	    //sort
	    Arrays.sort(randomNumbers);
	    
	    //Timer stops and returns runtime with median
	    long end = System.nanoTime();
		return randomNumbers[N/2] + ", and it took " + String.format( "%12.6f",((end-start)/Math.pow(10,9)));
	}
}