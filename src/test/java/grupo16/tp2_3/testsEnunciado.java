package grupo16.tp2_3;

import junit.framework.TestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import unitTestFWK.TestRunner;

public class testsEnunciado {

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testPerformance() {
		TestRunner testRunner = new TestRunner();
		TestSuite testSuite = new TestSuite("TS");
		TestCase1 testCase = new TestCase1("T1");
	}
}