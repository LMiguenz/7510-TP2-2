package main.java;

public class SelectionAlways extends SelectionStrategy {

	public SelectionAlways() {
		super(new TagList(), "", "");
	}

	@Override
	public boolean strategicSelection(Test test) {
		return true;
	}

}
