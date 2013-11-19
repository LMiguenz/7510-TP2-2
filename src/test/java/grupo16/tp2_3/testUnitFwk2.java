package grupo16.tp2_3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import unitTestFWK.TestExistsException;
import unitTestFWK.TestRunner;
import unitTestFWK.TestSuite;

public class testUnitFwk2 {

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testPerformance() {
		TestRunner testRunner = new TestRunner();
		TestSuite testSuite = new TestSuite("TS");
		TestCase1 testCase = new TestCase1("T1");
		testCase.setTimeLimit(6000);

		try {
			testSuite.addTest(testCase);
		}
		catch (TestExistsException e) {
			e.printStackTrace();
		}
		testRunner.startTesting(testSuite);
	}
}