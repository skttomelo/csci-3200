package assignment.driver;

import java.util.Comparator;

public class ComparatorExamples {

	/*BEGIN:DO NOT MODIFY*/
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
	/*END:DO NOT MODIFY*/

	public static void main(String[] args)
	{
		String[] arr = new String[]{"ABC", "CDE", "EFG", "zde", "ZFG"};
		System.out.println(findMax(arr, new CaseInsensitiveCompare()));


	}

	/*Comparator Example*/
	private static class CaseInsensitiveCompare implements Comparator<String>
	{
		//lhs = left hand side, rhs = right hand side
		public int compare(String lhs, String rhs)
		{
			return lhs.compareToIgnoreCase(rhs);
		}
	}

}
