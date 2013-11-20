package grupo16.tp2_3;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import unitTestFWK.TestExistsException;
import unitTestFWK.TestResultError;
import unitTestFWK.TestResultFail;
import unitTestFWK.TestResultOk;
import unitTestFWK.TestRunner;
import unitTestFWK.TestSuite;

public class testUnitFwk3 {

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testPerformance() {
		TestRunner testRunner = new TestRunner();
		TestSuite testSuite = new TestSuite("TS");
		TestCaseOk testCase1 = new TestCaseOk("T1");
		TestCaseError testCase2 = new TestCaseError("T2");
		TestCaseFail testCase3 = new TestCaseFail("T3");
		TestCaseOk testCase4 = new TestCaseOk("T4");
		TestResultOk resultExpectedOk = new TestResultOk("expectedOk");
		TestResultError resultExpectedError =
				new TestResultError("expectedError");
		TestResultFail resultExpectedFail = new TestResultFail("expectedFail");

		try {
			testSuite.addTest(testCase1);
			testSuite.addTest(testCase2);
			testSuite.addTest(testCase3);
		}
		catch (TestExistsException e) {
			e.printStackTrace();
		}

		testRunner.setXMLHistoryFileName("/home/martin/Descargas/history.xml");

		/* Corrida inicial */
		testRunner.startTesting(testSuite);

		assertEquals(resultExpectedOk.getCode(), testCase1.getResult()
				.getCode());
		assertEquals(resultExpectedError.getCode(), testCase2.getResult()
				.getCode());
		assertEquals(resultExpectedFail.getCode(), testCase3.getResult()
				.getCode());

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

		/* Hago de nuevo la corrida */
		// TODO poner la llamada al run que solo ejecute los fallidos segun
		// un archivo xml de historial
		testRunner.startTesting(testSuite);

		/* Verifico la nueva corrida */
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