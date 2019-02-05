package problem4;

import java.util.List;

public class problem4 {
	//array list formula: 4+((N^2)/2)+2N; O((N^2)/2)
	//linked list formula: 4+(3N/2)+C; O(N/2)
	public static void removeFirstHalf(List<?> lst){
		int theSize = lst.size( ) / 2; //2 units
		
		//1 unit assignment, 1 unit condition
		for(int i = 0; i < theSize; i++) //for loop runs for half of the list size making it N/2
			lst.remove( 0 ); //runtime of C; 2N units for i++; 1N unit for condition
	}
}
