
public class CubeSum {

	public static void main(String[] args) {
		long startTime, endTime = System.nanoTime();
		System.out.println(sum(2));//make sure everything has initialized in java before timing

		startTime = System.nanoTime();
		System.out.println(sum(10));//1^3+2^3+...
		endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));

		startTime = System.nanoTime();
		System.out.println(sum(100));//1^3+2^3+...
		endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));

		startTime = System.nanoTime();
		System.out.println(sum(1000));//1^3+2^3+...
		endTime = System.nanoTime();
		System.out.println("Runtime:" +
				String.format( "%12.6f",((endTime-startTime)/Math.pow(10,9))));
	}
	public static int sum(int n)//f(N) = 1 + 2+3N+4N+1 = 7N+4 ; O(f(N)) = O(7N+4) = O(N)
	{
		int opCount = 0;
		int partialSum;//zero
		partialSum = 0;//1 for assignment
		opCount++;

		//int i = 1// 1 unit for assignment
		opCount++;
		//i <= n// 1 unit for condition before entering loop
		opCount++;
		for(int i = 1; i <= n; i++)//1 for i = 1, 1 for initial comparison
			//, 2N for increment, 1N for condition
			//2+3N+4N //4N from work inside loop
		{
			partialSum += i*i*i;//2 multiply, 1 add, 1 assign = 4
			opCount+=4;

			//i++//i = i + 1 //2 units of time
			opCount+=2;
			//i <= n// 1 unit for condition
			opCount++;
		}

		opCount++;
		System.out.println("Operation count for "+n+" : " + opCount);
		return partialSum;//1
	}
}









