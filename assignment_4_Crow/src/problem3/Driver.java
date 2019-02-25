package problem3;

public class Driver {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		bst.insert(3);
		bst.insert(1);
		bst.insert(4);
		bst.insert(6);
		bst.insert(9);
		bst.insert(2);
		bst.insert(5);
		bst.insert(7);
		bst.insert(8);
		
		bst.printInLevelOrder();
	}
}
