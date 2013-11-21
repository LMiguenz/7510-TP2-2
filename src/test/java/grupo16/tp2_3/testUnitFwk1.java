package grupo16.tp2_3;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import unitTestFWK.TestExistsException;
import unitTestFWK.TestResultFail;
import unitTestFWK.TestResultOk;
import unitTestFWK.TestRunner;
import unitTestFWK.TestSuite;

public class testUnitFwk1 {

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testPerformanceFailed() {
		TestRunner testRunner = new TestRunner();
		TestSuite testSuite = new TestSuite("TS");
		TestCasePerformance testCase = new TestCasePerformance("T1");
		try {
			testSuite.addTest(testCase);
		}
		catch (TestExistsException e) {
			e.printStackTrace();
		}

		/* Demuestro que el test anda correctamente */
		testRunner.startTesting(testSuite);

		TestResultOk resultExpectedOk = new TestResultOk("expectedOk");
		assertEquals(resultExpectedOk.getCode(), testCase.getResult().getCode());

		/* Vuelvo a correr con time limit */
		testCase.setTimeLimit(4000);
		testRunner.startTesting(testSuite);

		TestResultFail resultExpectedFail = new TestResultFail("expectedFail");
		assertEquals(resultExpectedFail.getCode(), testCase.getResult()
				.getCode());
	}
}