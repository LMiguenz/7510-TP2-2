package grupo16.tp2_3;

import unitTestFWK.TestMethod;

public class TestCaseFail extends TestMethod {

	public TestCaseFail(String testName) {
		super(testName);
	}

	@Override
	protected void run() {
		equalsTrueTest();
	}

	private void equalsTrueTest() {
		assertTrue("equalsTrueTest", false);
	}
}