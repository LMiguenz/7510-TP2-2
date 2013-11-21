package unitTestFWK;


public class TestResultError extends TestResult {
	public final static String TEST_CODE = "Error";

	public TestResultError(String testName) {
		super(testName);
	}

	public String print() {
		return "[error] " + this.testName;
	}

	@Override
	public void updateMe(ResultPrinter printer) {
		printer.oneMoreTestErrored();
	}

	@Override
	public String getCode() {
		return TEST_CODE;
	}
}
