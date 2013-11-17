
public class TestRunner {
	
	private ResultPrinter printer;
	
	public TestRunner() {
		printer = new CmdLineResultPrinter();
	}
	
	public void startTesting(TestSuite testSuite) {
		testSuite.setPrinter(printer);
		long timeTestBegins = System.currentTimeMillis();
		testSuite.runTest();
		testSuite.setTimeElapsed(System.currentTimeMillis() - timeTestBegins);
		testSuite.getPrinter().printSummary();
	}

	public void useThisResultPrinter(ResultPrinter rp) {
		if (rp != null) {
			printer = rp;
		}
	}
}
