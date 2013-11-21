package grupo16.tp2_3;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import unitTestFWK.MemoryHashStorage;
import unitTestFWK.Storage;
import unitTestFWK.TestExistsException;
import unitTestFWK.TestResultError;
import unitTestFWK.TestResultFail;
import unitTestFWK.TestResultOk;
import unitTestFWK.TestRunner;
import unitTestFWK.TestSuite;
import unitTestFWK.XMLStorage;

public class testUnitFwk3 {
	private static TestRunner testRunner;
	private static TestSuite testSuite;
	private static TestCaseOk testCase1;
	private static TestCaseError testCase2;
	private static TestCaseFail testCase3;
	private static TestCaseOk testCase4;
	private static TestResultOk resultExpectedOk;
	private static TestResultError resultExpectedError;
	private static TestResultFail resultExpectedFail;
	private static Storage storage;

	@Before
	public void setUp() throws Exception {
		testRunner = new TestRunner();
		testSuite = new TestSuite("TS");
		testCase1 = new TestCaseOk("T1");
		testCase2 = new TestCaseError("T2");
		testCase3 = new TestCaseFail("T3");
		testCase4 = new TestCaseOk("T4");
		resultExpectedOk = new TestResultOk("expectedOk");
		resultExpectedError = new TestResultError("expectedError");
		resultExpectedFail = new TestResultFail("expectedFail");

		try {
			testSuite.addTest(testCase1);
			testSuite.addTest(testCase2);
			testSuite.addTest(testCase3);
		}
		catch (TestExistsException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testStorageWithFailedAndErrorAndNewMemoryHash() {
		storage = new MemoryHashStorage();

		primeraCorrida();
		segundaCorrida();
	}

	@Test
	public void testStorageWithFailedAndErrorAndNewXML() {
		storage = new XMLStorage("history.xml");

		primeraCorrida();
		segundaCorrida();
	}

	private void primeraCorrida() {
		testRunner.setStorage(storage);
		testRunner.startTesting(testSuite);

		assertEquals(resultExpectedOk.getCode(), testCase1.getResult()
				.getCode());
		assertEquals(resultExpectedError.getCode(), testCase2.getResult()
				.getCode());
		assertEquals(resultExpectedFail.getCode(), testCase3.getResult()
				.getCode());
	}

	private void segundaCorrida() {
		/* -------------Segunda corrida --------- */
		/* El T1 no se deberia ejecutar. De ejecutarse, su resultado seria
		 * de tipo "Ok". Se le cambia a tipo "Fail" para demostrar que no se
		 * ejecuto y por ende su resultado no cambio a "Ok" (esta es la forma
		 * que se encontro de hacer un assert de que no fue ejecutado) */
		/* Tambien le cambio los valores a los tests T2 y T3 para mostrar
		 * que se vuelven a ejecutar */
		testCase1.assertTrue(null, false);
		testCase2.assertTrue(null, true);
		testCase3.assertTrue(null, true);

		/* Chequeo los cambios de resultados */
		assertEquals(resultExpectedFail.getCode(), testCase1.getResult()
				.getCode());
		assertEquals(resultExpectedOk.getCode(), testCase2.getResult()
				.getCode());
		assertEquals(resultExpectedOk.getCode(), testCase3.getResult()
				.getCode());

		try {
			testSuite.addTest(testCase4);
		}
		catch (TestExistsException e) {
			e.printStackTrace();
		}
		
		testSuite.setToRunByTestResult(storage.restoreSuiteResults());
		testRunner.startTesting(testSuite);

		assertEquals(resultExpectedFail.getCode(), testCase1.getResult()
				.getCode());
		assertEquals(resultExpectedError.getCode(), testCase2.getResult()
				.getCode());
		assertEquals(resultExpectedFail.getCode(), testCase3.getResult()
				.getCode());
		assertEquals(resultExpectedOk.getCode(), testCase4.getResult()
				.getCode());
	}
}