package problem1;

import java.util.Random;

public class Main {
	public static void main(String[] args){
		Random random = new Random();
		random.nextInt();
		for(int a = 1; a<15;a++){
			int length = (int)Math.pow(10, a);
			int[] randomnum = new int[length];
			
			for(int i = 0; i<length; i++){
				randomnum[i] = random.nextInt();
			}
			
			long start = System.nanoTime();
			randomnum = sorter(randomnum);
			System.out.println(randomnum[length/2]);
			long end = System.nanoTime();
			System.out.println("Runtime for "+length+":" +
					String.format( "%12.6f",((end-start)/Math.pow(10,9))));
		}
	}
	
	private static int[] sorter(int[] array){
		int currentMax = array[0], arrayMaxPos = 0;
		for(int iterations = 0; iterations<array.length; iterations++){
			for(int i = arrayMaxPos+1; i<array.length; i++){
				if(currentMax <= array[i]){
					currentMax = array[i];
					arrayMaxPos = i;
					break;
				}else if(currentMax > array[i]){
					array[arrayMaxPos] = array[i]; //makes lower number take the place of bigger number
					array[i] = currentMax; //bigger number takes the place of the lower number essentially switching the two positions
					arrayMaxPos = i; //sets the new max position
				}
			}
		}
		return array;
	}
}
