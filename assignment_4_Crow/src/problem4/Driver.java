package problem4;

public class Driver {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> bst0 = new BinarySearchTree<Integer>();
		
		bst.insert(2);
		bst.insert(1);
		bst.insert(3);
		bst0.insert(4);
		bst0.insert(3);
		bst0.insert(5);
		System.out.println(bst.visuallyIdentical(bst0)); // visually identical
		bst0.insert(6);
		System.out.println(bst.visuallyIdentical(bst0)); // not visually identical
	}
}
