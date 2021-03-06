package assignment1;
import java.util.Random;

public class RuntimeExample {

	public static void main(String[] args) {
		//do work not to be timed
		int[] randoms1 = new int[1000];
		Random rand = new Random();
		rand.nextInt();

		//start timer
		long start = System.nanoTime();
		//do work to be timed
		System.out.println(randoms1.length);
		for(int i = 0; i < randoms1.length; i++)
		{
			randoms1[i] = rand.nextInt();
			System.out.println(randoms1[i]);
		}
		long end = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((end-start)/Math.pow(10,9))));

		//do work not to be timed
		int[] randoms2 = new int[2000];

		//restart timer
		long start2 = System.nanoTime();
		//do work to be timed
		System.out.println(randoms2.length);
		for(int i = 0; i < randoms2.length; i++)
		{
			randoms2[i] = rand.nextInt();
			System.out.println(randoms2[i]);
		}
		long end2 = System.nanoTime();



		System.out.println("Runtime for 100:" +
				String.format( "%12.6f",((end-start)/Math.pow(10,9))));
		System.out.println("Runtime for 200:" +
				String.format( "%12.6f",((end2-start2)/Math.pow(10,9))));

	}

}
