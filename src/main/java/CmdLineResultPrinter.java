package main.java;

public class CmdLineResultPrinter extends ResultPrinter {

	public CmdLineResultPrinter () {
		super();
	}
	
	public void printTest(Test test) {
		try {
			System.out.println(test.getResult().print() + " (" + test.getTimeElapsed() + "ms)");
			test.getResult().updateMe(this);
		} catch (NullPointerException e) { }
	}

	public void printSuite(TestSuite suite) {
		this.suiteName += "." + suite.getName();
		System.out.println(this.suiteName);
		System.out.println(SEPARATOR);

	}
	
	public void removeSuite(TestSuite suite) {
		//Remove the last added Suite name
		System.out.println("End of " + suiteName + " (" + suite.getTimeElapsed() + " ms)");
		suiteName = suiteName.substring(0, suiteName.lastIndexOf("."));
		System.out.println("");
	}
	
	public void printSummary() { 
		int totalTests = okTests + failedTests + errorTests;

		System.out.println(SUMMARY_HDR);
		System.out.println(DOUBLE_SEPARATOR);
		System.out.println("Run: " + totalTests);
		System.out.println("Errors: " + errorTests);
		System.out.println("Failures: " + failedTests);
	}
}
