package grupo16.tp2_3;

import unitTestFWK.TestMethod;

public class TestCasePerformance extends TestMethod {

	public TestCasePerformance(String testName) {
		super(testName);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {}
		equalsTrueTest();
	}

	private void equalsTrueTest() {
		assertTrue("equalsTrueTest", true);
	}
}