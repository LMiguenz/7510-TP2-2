package main.java;

public class Register {

	private Object valueA;
	private Object valueB;
	private Object result;
	
	public Register(Object valueA, Object valueB, Object result) {
		this.valueA = valueA;
		this.valueB = valueB;
		this.result = result;
	}
	
	public Object getValueA() {
		return valueA;
	}
	
	public Object getValueB() {
		return valueB;
	}
	
	public Object getRestult() {
		return result;
	}
}
