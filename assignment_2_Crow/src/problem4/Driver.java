package problem4;

public class Driver {
	
	
	public static int summationOne(int n){
		int sum = 0;
		for(int i = 0; i<n; i++){
			sum++;
		}
		return sum;
	}
	
	
	public static int summationTwo(int n){
		int sum = 0;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				sum++;
			}
		}
		return sum;
	}
	
	
	public static int summationThree(int n){
		int sum = 0;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<(n*n); j++){
				sum++;
			}
		}
		return sum;
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
		for(int = 25; i<201; i+=25){
			
		}
	}
	
}
