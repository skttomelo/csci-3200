package assignment1;
public class Recursive {

	public static void main(String[] args) {
		System.out.println(f(10));

	}

	public static int f(int x)
	{
		System.out.println("Run on: " + x);
		//base case
		if(x == 0)
			return 0;
		//recursive case
		int result = (2 * f(x-1)) + (int)Math.pow(x, 2);//f(x) = 2*f(x-1)+x^2
		return result;
	}

}
