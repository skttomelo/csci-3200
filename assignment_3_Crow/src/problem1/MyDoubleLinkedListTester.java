package problem1;

public class MyDoubleLinkedListTester {

	public static void main(String[] args) {
		MyDoubleLinkedList<Integer> mdll = new MyDoubleLinkedList<>();

		mdll.add(0);
		mdll.add(1);
		mdll.add(2);
		mdll.add(3);
		mdll.insert(5, 2);
		mdll.delete(4);
		mdll.swap(1);
		System.out.println("Forward");
		mdll.printList();
		System.out.println("Rev");
		mdll.printListRev();

	}

}
