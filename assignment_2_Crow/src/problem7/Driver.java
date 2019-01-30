package problem7;

import java.util.Random;

public class Driver {
	/*
	* Assignment:
	* Convert the following algorithm descriptions into working Java methods and estimate their big-o notation.
	* 
	* Algorithm 1: Fill the array 'a' from a[0] to a[n-1] as follows: To fill a[i], generate random numbers 
	* until you get one that is not already in a[0] to a[i-1].
	* 		
	* Algorithm 2: Same as algorithm 1, but keep an extra array called the 'used' array. When a random number, 
	* 'ran', is first put into the array 'a', set used[ran] = true. Now, when chosing a random number, 
	* no longer check ever position in 'a' before the one you are filling, just check the 'used' array.
	* 
	* Algorithm 3: Fill the array such that a[i] = i+1. Then,
	* for(i = 1; i < n; i++)
	* swapReferences(a[i], a[random(0,i)]);
	* *Note: Write your own swapReferences method to switch two given positions*
	*/
	
	public static int[] Algorithm1(int n){ //estimated Big-O: O(N^3)
		Random r = new Random();
		int[] a = new int[n-1];
		boolean dne = true;
		for(int i = 0; i<a.length; i++){
			a[i] = r.nextInt();
			do{
				if(i > 0){
					for(int j = 0; j<i; j++){
						if(a[i] == a[j]){
							a[i] = r.nextInt();
							dne = false;
						}else{
							dne = true;
						}
					}
				}
			}while(dne == false);
		}
		return a;
	}
	
	
	public static int[] Algorithm2(int n){ //estimated Big-O: O(N^2)
		Random r = new Random();
		int ran;
		int[] a = new int[n-1], used = new int[n-1];
		boolean dne = true;
		for(int i = 0; i<a.length; i++){
			ran = r.nextInt();
			if(i == 0) used[i] = ran;
			else{
				do{
					for(int j = 0; j<used.length; j++){
						if(ran == used[j]){
							ran = r.nextInt();
							dne = false;
						}else{
							dne = true;
						}
					}
				}while(dne == false);
			}
			a[i] = ran;
			used[i] = ran;
		}
		return a;
	}
	
	public static int[] Algorithm3(int n){ //estimated Big-O: O(N)
		int[] a = new int[n];
		Random r = new Random();
		for(int i = 0; i<n; i++){
			a[i] = i+1;
		}
		for(int i = 0; i<n; i++){
			if(i>0) swapReferences(i, r.nextInt(i), a);
		}
		return a;
	}
	public static void swapReferences(int x, int y, int[] array){ //estimated Big-O: O(C)
		int placeholder = array[y];
		array[y] = array[x];
		array[x] = placeholder;
	}
	
	public static void main(String[] args){
		int[] a;
		a = Algorithm1(10);
		System.out.println("Algorithm 1:");
		for(int i = 0; i<a.length; i++){
			System.out.print(a[i]+", ");
		}
		a = Algorithm2(10);
		System.out.println("\n\nAlgorithm 2:");
		for(int i = 0; i<a.length; i++){
			System.out.print(a[i]+", ");
		}
		a = Algorithm3(10);
		System.out.println("\n\nAlgorithm 3:");
		for(int i = 0; i<a.length; i++){
			System.out.print(a[i]+", ");
		}
	}
}
