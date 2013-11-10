package main.java;

public class CmdLineResultPrinter extends ResultPrinter {

	public CmdLineResultPrinter () {
		super();
	}
	
	public void printTest(Test test) {
		try {
//			buffer.add(test.getResult().print());
			System.out.println(test.getResult().print());
			test.getResult().updateMe(this);
		} catch (NullPointerException e) { }
	}

	public void printSuite(String suiteName) {
		this.suiteName += "." + suiteName;
		System.out.println(this.suiteName);
		System.out.println(SEPARATOR);
//		buffer.add(this.suiteName);
//		buffer.add(SEPARATOR);
	}
	
	public void removeSuite(String suiteName) {
		//Remove the last added Suite name
		this.suiteName.substring(0, this.suiteName.lastIndexOf("."));
		System.out.println("");
	}
	
	public void printSummary() { 
		int totalTests = okTests + failedTests + errorTests;
//		for (String s: buffer) {
//			System.out.println(s);
//		}
		
//		System.out.println("");
		System.out.println(SUMMARY_HDR);
		System.out.println(DOUBLE_SEPARATOR);
		System.out.println("Run: " + totalTests);
		System.out.println("Errors: " + errorTests);
		System.out.println("Failures: " + failedTests);
	}
}
