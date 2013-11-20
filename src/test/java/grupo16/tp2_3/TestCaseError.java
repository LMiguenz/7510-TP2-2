package grupo16.tp2_3;

import unitTestFWK.TestMethod;

public class TestCaseError extends TestMethod {

	public TestCaseError(String testName) {
		super(testName);
	}

	@Override
	protected void run() {
		throw new NullPointerException();
	}
}
