package unitTestFWK;

public class TestResultFail extends TestResult {
	
	public TestResultFail(String testName) {
		super (testName);
		setCodigo("FAIL");
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
		return "Fail";
	}
}
