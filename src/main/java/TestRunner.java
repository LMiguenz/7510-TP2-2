package main.java;

public class TestRunner {
	
	public void startTesting(TestSuite testSuite) {
		long timeTestBegins = System.currentTimeMillis();
		testSuite.runTest();
		testSuite.setTimeElapsed(System.currentTimeMillis() - timeTestBegins);
		testSuite.getPrinter().printSummary();
	}
	
	public void startTesting(TestSuite testSuite, String pattern) {
		long timeTestBegins = System.currentTimeMillis();
		testSuite.runTest(pattern);
		testSuite.setTimeElapsed(System.currentTimeMillis() - timeTestBegins);
		testSuite.getPrinter().printSummary();
	}
}
