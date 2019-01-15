package problem3;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Rectangle>{

	@Override
	public int compare(Rectangle arg0, Rectangle arg1) {
		if(arg0.getPerimeter()>arg1.getPerimeter()){
			return 1;
		}
		return 0;
	}
}
