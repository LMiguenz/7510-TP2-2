package main.java;

public abstract class TestMethod extends Test {

	protected abstract void run();
	
	public TestMethod(String testName) {
		super(testName);
	}

	@Override
	public void runTest() {
		long timeTestBegins = System.currentTimeMillis();
		try {
			run();
		} catch (Exception e) {
			setResult(new TestResultError(getName()));
		}
		setTimeElapsed(System.currentTimeMillis() - timeTestBegins);
		printer.printTest(this);
	}

}
