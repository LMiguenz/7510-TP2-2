package main.java;

public class TestRunner {
	
	public void startTesting(TestSuite testSuite) {
		testSuite.runTest();
		testSuite.getPrinter().printSummary();
	}
	
	public void startTesting(TestSuite testSuite, String pattern) {
		testSuite.runTest(pattern);
	}
}
