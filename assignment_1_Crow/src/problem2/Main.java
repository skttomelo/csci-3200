package problem2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a number to find out how many 1's are in it's binary representation.\n");
		System.out.println(numOfOnes(input.nextInt(), 0));
		input.close();
	}
	
	private static int numOfOnes(int N, int C){
		if(N == 0){
			return C;
		}if(N%2 != 0){
			C++;
		}
		return numOfOnes(N/2, C);
	}
}
