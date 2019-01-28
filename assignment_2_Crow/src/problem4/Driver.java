package problem4;

public class Driver {
	
	//formula: 1+2+3N+2N+1, O(N)
	public static int summationOne(int n){
		int sum = 0; //+1 for assignment
		//+1 for i=0; +1 for condition prior to entering loop
		for(int i = 0; i<n; i++){ //3N + 2N
			sum++; //2N for assignment and addition
			//i++ is 2N for assignment and addition
			//1N for condition
		}
		return sum; //+1
	}
	
	//formula: 1+2+(N^2)+3N+2N+N+2N+1, O(N^2)
	public static int summationTwo(int n){
		int sum = 0; //+1
		//+2 for i=0 and condition prior to entering loop
		for(int i = 0; i<n; i++){ //N^2+3N
			//2N for j=0 and condition prior to entering loop
			for(int j = 0; j<n; j++){ //2N+N+2N
				sum++; //2N for assignment and addition
				//2N for j assignment and addition
				//1N for condition
			}
			//2N for i assignment and addition
			//1N for condition
		}
		return sum; //+1
	}
	
	//formula: 1+2+N^2+4N+3N+3N+2N+1, O(N^2)
	public static int summationThree(int n){
		int sum = 0; //+1
		//+2 for i=0 and condition prior to entering loop
		for(int i = 0; i<n; i++){ //N^2+4N+3N
			//3N for J=0 and condition prior to entering loop and multiplication
			for(int j = 0; j<(n*n); j++){ //3N+2N
				sum++; //2N for assignment and addition
				//2N for j assignment and addition
				//1N for condition
			}
			//2N for i assignment and addition
			//2N for condition and multiplication
		}
		return sum; //+1
	}
	
	
	public static int summationFour(int n){
		int sum = 0;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<i; j++){
				sum++;
			}
		}		
		return sum;
	}
	
	
	public static int summationFive(int n){
		int sum = 0;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<i*i; j++){
				for(int k = 0; k<j;k++){
					sum++;
				}
			}
		}		
		return sum;
	}
	
	
	public static int summationSix(int n){
		int sum = 0;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<i*i; j++){
				if(j%i == 0){
					for(int k = 0; k<j;k++){
						sum++;
					}
				}
			}
		}	
		return sum;
	}
	
	public static void main(String[] args){
		for(int i = 25; i<201; i+=25){
			System.out.println("");
		}
	}
	
}
