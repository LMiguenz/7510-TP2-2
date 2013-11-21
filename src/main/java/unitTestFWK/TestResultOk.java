package unitTestFWK;

public class TestResultOk extends TestResult {
	public final static String TEST_CODE = "Ok";
	
	public TestResultOk(String testName) {
		super (testName);
	}
	
	public String print() {
		return "[ok] " + this.testName;
	}

	@Override
	public void updateMe(ResultPrinter printer) {
		printer.oneMoreTestOk();
	}

	@Override
	public String getCode() {
		return TEST_CODE;
	}
}
