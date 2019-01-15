package problem3;

import java.util.Comparator;

public class Main {
	public static <AnyType> AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp)
	{
		int maxIndex = 0;

		for(int i = 1; i < arr.length; i++)
		{
			if(cmp.compare(arr[i], arr[maxIndex]) > 0)
			{
				maxIndex = i;
			}
		}

		return arr[maxIndex];
	}
	public static void main(String[] args){
		Rectangle[] rectangles = new Rectangle[]{new Rectangle(10000,1),new Rectangle(100,100),new Rectangle(100,23),new Rectangle(50,500),new Rectangle(15,250)};
		System.out.println("Largest Perimeter: "+findMax(rectangles, new PerimeterComparator()));
		System.out.println("Largest Area: "+findMax(rectangles, new AreaComparator()));
	}
}
