package problem5;

public class EquationBinaryTreeTester {

	public static void main(String[] args) {
		EquationBinaryTree ebt = new EquationBinaryTree();

		ebt.populateFromInfix("(a+b)");
		ebt.printInfix();
		ebt.printPostfix();
		ebt.printPrefix();

		ebt.populateFromInfix("((d/e)*f)");
		ebt.printInfix();
		ebt.printPostfix();
		ebt.printPrefix();
		/**/
		ebt.populateFromInfix("(a+(b+c))");
		ebt.printInfix();
		ebt.printPostfix();
		ebt.printPrefix();

		System.out.println();
		ebt.populateFromInfix("((a+(b*c))+(((d*e)+f)*g))");
		ebt.printInfix();
		ebt.printPostfix();
		ebt.printPrefix();
		/**/

		ebt.populateFromPrefix("++a*bc*+*defg");
		ebt.printInfix();
		ebt.printPostfix();
		ebt.printPrefix();
		ebt.populateFromPostfix("abc*+de*f+g*+");
		ebt.printInfix();
		ebt.printPostfix();
		ebt.printPrefix();

	}

}
