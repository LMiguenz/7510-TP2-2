package unitTestFWK;

public class TestRunner {

	private ResultPrinter printer;
	private Storage storage;

	public TestRunner() {
		printer = new CmdLineResultPrinter();
		storage = new MemoryHashStorage();
	}

	public void startTesting(TestSuite testSuite) {
		testSuite.setPrinter(printer);
		long timeTestBegins = System.currentTimeMillis();
		testSuite.runTest();
		testSuite.setTimeElapsed(System.currentTimeMillis() - timeTestBegins);
		testSuite.getPrinter().printSummary();
		storage.storeSuiteResults(testSuite);
	}

	public void useThisResultPrinter(ResultPrinter rp) {
		if (rp != null) {
			printer = rp;
		}
	}

	/* Setea el storage que se desea utilizar */
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
}