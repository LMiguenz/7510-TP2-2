package unitTestFWK;

public class TestResultFail extends TestResult {
	public final static String TEST_CODE = "Fail";
	
	public TestResultFail(String testName) {
		super (testName);
	}
	
	public String print() {
		return "[fail] " + this.testName;
	}

	@Override
	public void updateMe(ResultPrinter printer) {
		printer.oneMoreTestFailed();
	}

	@Override
	public String getCode() {
		return TEST_CODE;
	}
}
