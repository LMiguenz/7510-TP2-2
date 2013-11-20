package grupo16.tp2_3;

import unitTestFWK.TestMethod;

public class TestCaseOk extends TestMethod {

	public TestCaseOk(String testName) {
		super(testName);
	}

	@Override
	public void run() {
		equalsTrueTest();
	}

	private void equalsTrueTest() {
		assertTrue("equalsTrueTest", true);
	}
}