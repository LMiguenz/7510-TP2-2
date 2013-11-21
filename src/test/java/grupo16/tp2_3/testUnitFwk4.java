package grupo16.tp2_3;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import unitTestFWK.MemoryHashStorage;
import unitTestFWK.Storage;
import unitTestFWK.TestExistsException;
import unitTestFWK.TestResultFail;
import unitTestFWK.TestResultOk;
import unitTestFWK.TestRunner;
import unitTestFWK.TestSuite;

public class testUnitFwk4 {

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testPerformanceNoFailNorErrorNorNew() {
		TestRunner testRunner = new TestRunner();
		TestSuite testSuite = new TestSuite("TS");
		TestCaseOk testCase1 = new TestCaseOk("T1");
		TestCaseOk testCase2 = new TestCaseOk("T2");
		TestCaseOk testCase3 = new TestCaseOk("T3");
		TestResultOk resultExpectedOk = new TestResultOk("expectedOk");
		TestResultFail resultExpectedFail = new TestResultFail("expectedFail");

		try {
			testSuite.addTest(testCase1);
			testSuite.addTest(testCase2);
			testSuite.addTest(testCase3);
		}
		catch (TestExistsException e) {
			e.printStackTrace();
		}
		
		Storage storage = new MemoryHashStorage();
		testRunner.setStorage(storage);

		/* Corrida inicial */
		testRunner.startTesting(testSuite);

		assertEquals(resultExpectedOk.getCode(), testCase1.getResult()
				.getCode());
		assertEquals(resultExpectedOk.getCode(), testCase2.getResult()
				.getCode());
		assertEquals(resultExpectedOk.getCode(), testCase3.getResult()
				.getCode());

		/* -------------Segunda corrida --------- */
		/* El T1, T2 y T3 no se deberian ejecutar. De ejecutarse, sus
		 * resultados serian de tipo "Ok". Se les cambia a tipo "Fail" para
		 * demostrar que no se ejecutaron y por ende sus resultados no
		 * cambiaron a "Ok" (esta es la forma que se encontro de hacer un
		 * assert de que no fue ejecutado) */
		testCase1.assertTrue(null, false);
		testCase2.assertTrue(null, false);
		testCase3.assertTrue(null, false);

		/* Chequeo los cambios de resultados */
		assertEquals(resultExpectedFail.getCode(), testCase1.getResult()
				.getCode());
		assertEquals(resultExpectedFail.getCode(), testCase2.getResult()
				.getCode());
		assertEquals(resultExpectedFail.getCode(), testCase3.getResult()
				.getCode());

		/* Hago de nuevo la corrida */
		testSuite.setToRunByTestResult(storage.restoreSuiteResults());;
		testRunner.startTesting(testSuite);

		/* Verifico la nueva corrida */
		assertEquals(resultExpectedFail.getCode(), testCase1.getResult()
				.getCode());
		assertEquals(resultExpectedFail.getCode(), testCase2.getResult()
				.getCode());
		assertEquals(resultExpectedFail.getCode(), testCase3.getResult()
				.getCode());
	}
}