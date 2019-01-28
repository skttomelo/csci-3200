
public class Exponentiation {

	public static int shortOpCount = 0, shortMultCount = 0;

	public static void main(String[] args) {
		long n = 5, m = 60;
		// TODO Auto-generated method stub
		System.out.println("Answer:"+standardMulitply(n, m));
		System.out.println();
		System.out.println("Answer:"+shortMultiply(n, m));
		System.out.println("Ops:"+shortOpCount);
		System.out.println("Mult:"+shortMultCount);
	}

	public static boolean isEven(long m)
	{
		shortOpCount+=3;//mod, compare, return
		return (m%2==0);
	}

	public static long shortMultiply(long n, long m)
	{
		shortOpCount++;//comparison
		if(m == 1)
		{
			shortOpCount++;//return
			return n;
		}
		else
		{
			shortOpCount++;
			if(isEven(m))
			{
				shortMultCount++;
				shortOpCount+=3;//mult, div, return
				return shortMultiply(n*n, m/2);
			}
			else
			{
				shortMultCount+=2;
				shortOpCount+=4;//mult, div, mult, return
				return shortMultiply(n*n, m/2)*n;
			}
		}
	}

	public static long standardMulitply(long n, long m)
	{
		//n^m
		int opCount = 0, multiCount = 0;
		long sum = n;
		opCount++;
		opCount++;//i=1
		opCount++;//i<=m
		for(int i = 1; i < m; i++)
		{
			sum *= n;
			multiCount++;
			opCount +=2;

			opCount++;//i<=m
			opCount+=2;//i++
		}
		opCount++;//return
		System.out.println("Operations:"+opCount);
		System.out.println("Multiply:"+multiCount);
		return sum;
	}

}
