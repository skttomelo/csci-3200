import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MapTesting {

	public static void main(String[] args) {
		Set<Integer> m1 = new TreeSet<>();
		Set<Integer> m2 = new HashSet<>();
		//generate randoms
		Random r = new Random();
		Integer[] a = new Integer[100];
		for(int i = 0; i < a.length; i++)
			a[i] = r.nextInt();
		//run tree methods
		long startTree = System.nanoTime();
		for(int i = 0; i < a.length; i++)
			m1.add(a[i]);
		for(int i = 0; i < a.length; i++)
			m1.contains(a[i]);
		long endTree = System.nanoTime();
		//run hash methods
		long startHash = System.nanoTime();
		for(int i = 0; i < a.length; i++)
			m2.add(a[i]);
		for(int i = 0; i < a.length; i++)
			m2.contains(a[i]);
		long endHash = System.nanoTime();

		System.out.println("Tree:" +
				String.format( "%12.6f",((endTree-startTree)/Math.pow(10,9))));
		System.out.println("Hash:" +
				String.format( "%12.6f",((endHash-startHash)/Math.pow(10,9))));

	}

}
