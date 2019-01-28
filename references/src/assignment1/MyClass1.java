package assignment1;
public class MyClass1 implements Comparable<MyClass1>  {
	private String name;
	private int val1;
	private double val2;
	public MyClass1(int val1, double val2) {
		super();
		this.val1 = val1;
		this.val2 = val2;
	}
	public MyClass1(String name, int val1, double val2) {
		super();
		this.name = name;
		this.val1 = val1;
		this.val2 = val2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVal1() {
		return val1;
	}
	public void setVal1(int val1) {
		this.val1 = val1;
	}
	public double getVal2() {
		return val2;
	}
	public void setVal2(double val2) {
		this.val2 = val2;
	}
	@Override
	public String toString() {
		return "MyClass1 [name=" + name + ", val1=" + val1 + ", val2=" + val2 + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + val1;
		long temp;
		temp = Double.doubleToLongBits(val2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyClass1 other = (MyClass1) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (val1 != other.val1)
			return false;
		if (Double.doubleToLongBits(val2) != Double.doubleToLongBits(other.val2))
			return false;
		return true;
	}
	@Override
	public int compareTo(MyClass1 arg0) {
		return this.name.compareTo(arg0.name);
	}
}
