package problem3;

public class BinarySearchTree<E extends Comparable<? super E>> {
	private Node root;

	public BinarySearchTree()
	{
		root = null;
	}

	public void printTree()
	{
		printTree(root);
	}
	private void printTree(Node current)
	{
		if(current != null)
		{
			String content = "Current:"+current.data.toString();
			if(current.left != null)
			{
				content += "; Left side:"+current.left.data.toString();
			}
			if(current.right != null)
			{
				content += "; Right side:"+current.right.data.toString();
			}
			System.out.println(content);
			printTree(current.left);
			printTree(current.right);

		}
	}
	public void printInOrder()
	{
		System.out.print("In order:");
		printInOrder(root);
		System.out.println();
	}
	private void printInOrder(Node current)
	{
		if(current != null)
		{
			printInOrder(current.left);
			System.out.print(current.data.toString()+",");
			printInOrder(current.right);
		}
	}
	public boolean contains(E val)
	{
		Node result = findNode(val, root);

		if(result != null)
			return true;
		else
			return false;
	}
	private Node findNode(E val, Node current)
	{
		//base cases
		if(current == null)
			return null;
		if(current.data.equals(val))
			return current;

		//recursive cases
		int result = current.data.compareTo(val);
		if(result < 0)
			return findNode(val, current.right);
		else
			return findNode(val, current.left);
	}
	public E findMin()
	{
		Node result = findMin(root);
		if(result == null)
			return null;
		else
			return result.data;
	}
	private Node findMin(Node current)
	{
		while(current.left != null)
		{
			current = current.left;
		}
		return current;
	}
	public E findMax()
	{
		Node current = root;
		while(current.right != null)
		{
			current = current.right;
		}
		return current.data;
	}
	public void insert(E val)
	{
		root = insertHelper(val, root);
	}
	public Node insertHelper(E val, Node current)
	{
		/* for showing steps to insert a given value
		if(val.equals(9) && current != null)
		{
			System.out.println(current.data);
		}
		*/

		if(current == null)
		{
			return new Node(val);
		}
		int result = current.data.compareTo(val);
		if(result < 0)
		{
			current.right = insertHelper(val, current.right);
		}
		else if(result > 0)
		{
			current.left = insertHelper(val, current.left);
		}
		else//update
		{
			current.data = val;
		}
		return current;
	}
	public void remove(E val)
	{
		root = removeHelper(val, root);
	}
	private Node removeHelper(E val, Node current)
	{
		if(current.data.equals(val))
		{
			if(current.left == null && current.right == null)//no children
			{
				return null;
			}
			else if(current.left != null && current.right != null)//two children
			{
				Node result = findMin(current.right);
				result.right = removeHelper(result.data, current.right);
				result.left = current.left;
				return result;
			}
			else//one child
			{
				return (current.left != null)? current.left : current.right;
			}
		}
		int result = current.data.compareTo(val);
		if(result < 0)
		{
			current.right = removeHelper(val, current.right);
		}
		else if(result > 0)
		{
			current.left = removeHelper(val, current.left);
		}
		return current;
	}
	
	//problem 3
	public void printInLevelOrder() {
		MyQueue<Node> queue = new MyQueue<>();
		queue.enqueue(root);
		while(queue.peek() != null) { //unlike the below code that is commented out this runs in O(N) because I don't use recursion and I use a a queue in which all methods have a runtime of O(1)
			//the while loop technically will run until there is nothing left which technically makes it have a Big-O of O(N) because it will run N times
			Node current = queue.dequeue();
			System.out.print(current.data.toString()+", ");
			if(current.left != null) {
				queue.enqueue(current.left);
			}
			if(current.right != null) {
				queue.enqueue(current.right);
			}
		}
	}
//	private int height(Node current) { // it will always return the actual height-1 when it finishes the recursion sequence
//		//this entire method is O(N)
//		if(current == null) {
//			return 0;
//		}
//		int leftheight = height(current.left); //recursion so that we go back through and check if the next node will have a value or not to add to the total
//		int rightheight = height(current.right); // the same applies from above only with the right heigh and not the left height
//		if(leftheight>rightheight)return leftheight+1; // height increases by 1 in left height
//		else return rightheight+1; // height increases by 1 in right height
//	}
//	private void printInLevelOrder(Node current, int level) {
//		if(current == null) {
//			return; // do nothing
//		}else if(level == 1) {
//			System.out.print(current.data.toString()+", "); // used for printing out the current node when level == 1
//		}else if(level > 1) {
//			printInLevelOrder(current.left, level-1); // we want to print all the left nodes that reside in the current level - 1 because we need to capture level 1 as well so we don't skip over it
//			printInLevelOrder(current.right, level-1); // the same applies from above only with the right nodes in the tree
//		}
//	}

	private class Node
	{
		E data;
		Node left, right;
		public Node(E d)
		{
			data = d;
			left = null;
			right = null;
		}
	}

}
