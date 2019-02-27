package problem5;

public class EquationBinaryTreeTester {

	public static void main(String[] args) {
		EquationBinaryTree ebt = new EquationBinaryTree();

//		ebt.populateFromInfix("(a+b)");
//		ebt.printInfix();
//		ebt.printPostfix();
//		ebt.printPrefix();
//
//		ebt.populateFromInfix("((d/e)*f)");
//		ebt.printInfix();
//		ebt.printPostfix();
//		ebt.printPrefix();
//		/**/
//		ebt.populateFromInfix("(a+(b+c))");
//		ebt.printInfix();
//		ebt.printPostfix();
//		ebt.printPrefix();
//
//		ebt.populateFromInfix("((a+(b*c))+(((d*e)+f)*g))");
//		ebt.printInfix();
//		ebt.printPostfix();
//		ebt.printPrefix();
//		/**/
//		
//		System.out.println();
		ebt.populateFromPrefix("++a*bc*+*defg");
		ebt.printInfix();
		ebt.printPostfix();
		ebt.printPrefix();
//		ebt.populateFromPostfix("abc*+de*f+g*+");
//		ebt.printInfix();
//		ebt.printPostfix();
//		ebt.printPrefix();

	}
	
	/*5. Expand EquationBinaryTree to include a populate method for prefix and postfix.
	 * Method headers included in the file on D2L. The populate methods should not convert to the other type before populating the tree nodes. Add Big-O notation to all 3 populate methods.
	 * Bonus for #5, list the best case, average case, and worst case Big-O runtime for the populate from infix and describe what causes each.
	 * Collecting operation counts may be helpful in determining and confirming these values.*/

}
