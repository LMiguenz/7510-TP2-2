package main.java;

public abstract class TestMethod extends Test {

	protected abstract void run();
	
	public TestMethod(String testName) {
		super(testName);
	}

	@Override
	public void runTest() {
		run();
		printer.printTest(this);
	}

}
