package problem3;

import java.util.Comparator;

public class AreaComparator implements Comparator<Rectangle>{

	@Override
	public int compare(Rectangle o1, Rectangle o2) {
		if(o1.getArea()>o2.getArea()){
			return 1;
		}
		return 0;
	}
	
}
