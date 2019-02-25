package problem1;

public class Driver {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		//inserting values into the binary search tree
		bst.insert(3);
		bst.printTree();
		System.out.println();
		bst.insert(1);
		bst.printTree();
		System.out.println();
		bst.insert(4);
		bst.printTree();
		System.out.println();
		bst.insert(6);
		bst.printTree();
		System.out.println();
		bst.insert(9);
		bst.printTree();
		System.out.println();
		bst.insert(2);
		bst.printTree();
		System.out.println();
		bst.insert(5);
		bst.printTree();
		System.out.println();
		bst.insert(7);
		bst.printTree();
		System.out.println();
		bst.insert(8);
		bst.printTree();
		System.out.println("\nThe below is the root node being removed:");
		
		//removing the root 3 times
		bst.remove(3);
		bst.printTree();
		System.out.println();
		bst.remove(4);
		bst.printTree();
		System.out.println();
		bst.remove(5);
		bst.printTree();
		System.out.println();
		
	}
}
