package problem5;

public class EquationBinaryTree {
	private Node root;

	public EquationBinaryTree() {
		root = null;
	}

	// (left parent right)
	// (->left->parent->right->)
	public void printInfix() {
		printInfixHelper(root);
		System.out.println();
	}

	private void printInfixHelper(Node n)// O(N) - visit each node only once
	{
		if (n != null && n.left != null) {
			System.out.print("(");
			printInfixHelper(n.left);// left side
			System.out.print(n.value);// middle item//parent
			printInfixHelper(n.right);// right side
			System.out.print(")");
		} else if (n != null) {
			System.out.print(n.value);// middle item//parent
		}
	}

	// left -> right -> parent
	public void printPostfix() {
		printPostfixHelper(root);
		System.out.println();
	}

	private void printPostfixHelper(Node n) {
		if (n != null && n.left != null) {
			printPostfixHelper(n.left);// left side
			printPostfixHelper(n.right);// right side
			System.out.print(n.value);// middle item//parent
		} else if (n != null) {
			System.out.print(n.value);// middle item//parent
		}
	}

	// parent -> left -> right
	public void printPrefix() {
		printPrefixHelper(root);
		System.out.println();
	}

	private void printPrefixHelper(Node n) {
		if (n != null && n.left != null) {
			System.out.print(n.value);// middle item//parent
			printPrefixHelper(n.left);// left side
			printPrefixHelper(n.right);// right side
		} else if (n != null) {
			System.out.print(n.value);// middle item//parent
		}
	}

	// (a+b)
	// (a+(b*c))
	// ((a*b)+c)
	public void populateFromInfix(String equation) { // O(N)
		root = populateFromInfixHelper(equation);
	}

	public Node populateFromInfixHelper(String equation) { // O(N)
		if (equation.length() == 1) {
			return new Node(equation);// math operand
		}

		// System.out.println(equation);
		String temp = equation.substring(1, equation.length() - 1);// remove wrapper paren

		// begin search for middle of equation
		int parenCount = 0;
		int mid = 0;
		for (int i = 0; i < temp.length(); i++) { //O(N-2)
			if (temp.charAt(i) == '(')
				parenCount++;
			if (temp.charAt(i) == ')')
				parenCount--;
			if (parenCount == 0) {
				mid = i + 1;
				break;
			}
		}
		// middle
		Node n = new Node("" + temp.charAt(mid));
		// first half
		n.left = populateFromInfixHelper(temp.substring(0, mid));
//		System.out.println(temp.substring(0, mid));
		// second half
		n.right = populateFromInfixHelper(temp.substring(mid + 1));
//		System.out.println(temp.substring(mid+1));

		return n;
	}

	// ab+ = (a+b)
	public void populateFromPostfix(String equation) { // O(N) best case scenario would be O(1)
		// complete this section for #5 from Assignment 4
		// does not require recursion to solve
		root = populateFromPostFixHelper(equation);
	}

	private Node populateFromPostFixHelper(String equation) { // O(N) where N is the length of the equation
		if (equation.length() == 1) {
			return new Node(equation);
		}
		MyStack<Node> stack = new MyStack<Node>();
		Node current;

		for (int i = 0; i < equation.length(); i++) {
			current = new Node("" + equation.charAt(i));
			if (equation.charAt(i) != '+' && equation.charAt(i) != '-' && equation.charAt(i) != '*' && equation.charAt(i) != '/' && equation.charAt(i) != '^') {
				stack.push(current);
			} else {
				current.right = stack.pop();
				current.left = stack.pop();

				stack.push(current);
			}
		}

		current = stack.pop();

		return current;
	}

	// +ab = (a+b)
	public void populateFromPrefix(String equation) { // O(N) if I knew how to implement this, but as it stands without everything it's O(1)
		// complete this section for #5 from Assignment 4
		// does not require recursion to solve

		root = populateFromPrefixHelper(equation);
	}

	private Node populateFromPrefixHelper(String equation) {
		if (equation.length() == 1) {
			root = new Node(equation);
		}
		return null;
	}

	private class Node {
		String value;
		Node left, right;

		public Node(String v) {
			value = v;
			left = null;
			right = null;
		}
	}
}
