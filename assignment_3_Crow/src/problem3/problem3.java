package problem3;

import java.util.ArrayList;
import java.util.List;

public class problem3 {
	public static List<Integer> makeList(int N){ //O(N^2)
		ArrayList<Integer> lst = new ArrayList<>( ); //1 unit
		//2 units
		for( int i = 0; i < N; i++ ){ //O(N^2)
			lst.add( i ); //O(N)
			lst.trimToSize( ); //O(N)
			//3 units
		}
		
		//line below I added because it was missing
		return lst; //1 unit
	}
}
