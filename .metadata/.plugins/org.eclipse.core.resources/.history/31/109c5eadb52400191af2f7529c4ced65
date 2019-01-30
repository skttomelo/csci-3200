package problem4;

public class Driver {
	
	//formula: 1+2+3N+2N+1, O(N)
	public static int summationOne(int n){
		int opCount = 0;
		int sum = 0; //+1 for assignment
		opCount++;
		//+1 for i=0; +1 for condition prior to entering loop
		opCount+=2;
		for(int i = 0; i<n; i++){ //3N + 2N
			sum++; //2N for assignment and addition
			opCount+=2;
			//i++ is 2N for assignment and addition
			opCount+=2;
			//1N for condition
			opCount++;
		}
		opCount++;
		System.out.println("summationOne operation counts where n="+n+": "+opCount);
		return sum; //+1
	}
	
	//formula: 1+2+1+(3N+2N)(5N)=4+(25N^2), O(N^2)
	public static int summationTwo(int n){
		int opCount = 0;
		int sum = 0; //+1
		opCount++;
		//+2 for i=0 and condition prior to entering loop
		opCount+=2;
		for(int i = 0; i<n; i++){ //3N+2N
			//2N for j=0 and condition prior to entering loop
			opCount+=2;
			for(int j = 0; j<n; j++){ //2N+N+2N = 5N
				sum++; //2N for assignment and addition
				opCount+=2;
				//2N for j assignment and addition
				opCount+=2;
				//1N for condition
				opCount++;
			}
			//2N for i assignment and addition
			opCount+=2;
			//1N for condition
			opCount++;
		}
		opCount++;
		System.out.println("summationTwo operation counts where n="+n+": "+opCount);
		return sum; //+1
	}
	
	//formula: 1+2+1+36N^3 = 4+36N^3, O(N^3)
	public static int summationThree(int n){
		int opCount = 0;
		int sum = 0; //+1
		opCount++;
		//+2 for i=0 and condition prior to entering loop
		opCount+=2;
		for(int i = 0; i<n; i++){ //(3N+3N)6N^2 = 36N^3
			//3N for j=0 and condition prior to entering loop and multiplication
			opCount+=3;
			for(int j = 0; j<(n*n); j++){ //(4N+2N)N = 6N^2 //we multiply by N because of the n*n
				sum++; //2N for assignment and addition
				opCount+=2;
				//2N for j assignment and addition
				opCount+=2;
				//2N for condition and multiplication
				opCount+=2;
			}
			//2N for i assignment and addition
			opCount+=2;
			//1N for condition
			opCount++;
		}
		opCount++;
		System.out.println("summationThree operation counts where n="+n+": "+opCount);
		return sum; //+1
	}
	
	//formula: 25N^2+4, O(N^2)
	public static int summationFour(int n){
		int opCount = 0;
		int sum = 0; //+1
		opCount++;
		//+2 for i=0 and condition prior to entering loop
		opCount+=2;
		for(int i = 0; i<n; i++){ //5N(5N) = 25N^2
			//2N for j=0 and condition prior to entering the loop
			opCount+=2;
			for(int j = 0; j<i; j++){ //2N+2N+1N = 5N
				sum++; //2N for assignment and addition
				opCount+=2;
				//2N for i assignment and addition
				opCount+=2;
				//1N for condition
				opCount++;
			}
			//2N for i assignment and addition
			opCount+=2;
			//1N for condition
			opCount++;
		}
		opCount++;
		System.out.println("summationFour operation counts where n="+n+": "+opCount);
		return sum; //+1
	}
	
	//formula: 180N^3+4, O(N^3)
	public static Long summationFive(int n){
		long opCount = 0;
		long sum = 0; //+1
		opCount++;
		//+2 for i=0 and condition prior to entering loop
		opCount+=2;
		for(long i = 0; i<n; i++){ //(3N+3N)30N^2 = 180N^3
			//3N for j=0 and condition prior to entering the loop and also multiplication
			opCount+=3;
			for(long j = 0; j<i*i; j++){ //6N(5N) = 30N^2
				//2N for k=0 and condition prior to entering the loop
				opCount+=2;
				for(long k = 0; k<j;k++){ //2N+2N+1N = 5N
					sum++; //2N for assignment and addition
					opCount+=2;
					//2N for k assignment and addition
					opCount+=2;
					//1N for condition
					opCount++;
				}
				//2N for j assignment and addition
				opCount+=2;
				//2N for condition and multiplication
				opCount+=2;
			}
			//2N for i assignment and addition
			opCount+=2;
			//1N for condition
			opCount++;
		}
		opCount++;
		System.out.println("summationFive operation counts where n="+n+": "+opCount);
		return sum; //+1
	}
	
	//formula: 78N^2+5, O(N^2)
	public static int summationSix(int n){
		int opCount = 0;
		int sum = 0; //+1
		opCount++;
		int j = 0; //+1
		opCount++;
		//+2 for i=0 and condition prior to entering loop
		opCount+=2;
		for(int i = 1; j<n; i++){ //6N(13N) = 78N^2
			//3N for k=0 and condition prior to entering the loop and also multiplication
			opCount+=3;
			for(j = 1; j<i*i; j++){ //8N + 5N = 13N
				//2N for condition and mod
				opCount+=2;
				if(j%i == 0){
					//2N for k=0 and condition prior to entering the loop
					opCount+=2;
					for(int k = 0; k<j;k++){ //5N
						sum++; //2N for assignment and addition
						opCount+=2;
						//2N for k assignment and addition
						opCount+=2;
						//1N for condition
						opCount++;
					}
				}
				//2N for j assignment and addition
				opCount+=2;
				//2N for condition and multiplication
				opCount+=2;
			}
			//2N for i assignment and addition
			opCount+=2;
			//1N for condition
			opCount++;
		}
		opCount++;
		System.out.println("summationSix operation counts where n="+n+": "+opCount);
		return sum; //+1
	}
	
	
	public static void main(String[] args){
		for(int i = 25; i<201; i+=25){
			System.out.println(summationOne(i));
			System.out.println(summationTwo(i));
			System.out.println(summationThree(i));
			System.out.println(summationFour(i));
			System.out.println(summationFive(i));
			System.out.println(summationSix(i));
		}
	}
	
}
