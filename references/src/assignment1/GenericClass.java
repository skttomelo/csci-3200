package assignment1;
public class GenericClass<AnyType> {
	private AnyType something;

	public GenericClass(AnyType something) {
		super();
		this.something = something;
	}

	public AnyType getSomething() {
		return something;
	}

	public void setSomething(AnyType something) {
		this.something = something;
	}

}
