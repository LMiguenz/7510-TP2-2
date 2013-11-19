package grupo16.tp2_3;

import unitTestFWK.TestMethod;

public class TestCase1 extends TestMethod {

	public TestCase1(String testName) {
		super(testName);
	}

	@Override
	public void run() {
		System.out.println("\nT1 Performance Test");
		try {
			Thread.sleep(5000);;
		}
		catch (InterruptedException e) {}
		equalsTrueTest();
	}
	
	private void equalsTrueTest() {
		assertTrue("equalsTrueTest", true);
	}
}