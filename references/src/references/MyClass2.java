package references;
public class MyClass2 extends MyClass1 {
	private int val3;

	public MyClass2(String name, int val1, double val2) {
		super(name, val1, val2);
		// TODO Auto-generated constructor stub
	}

	public MyClass2(int val1, double val2, int val3) {
		super(val1, val2);
		this.val3 = val3;
	}

}
