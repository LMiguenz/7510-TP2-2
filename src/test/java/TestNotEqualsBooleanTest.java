package test.java;

import main.java.TestMethod;

public class TestNotEqualsBooleanTest extends TestMethod {

	public TestNotEqualsBooleanTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		testNotEqualsBooleanTest();
	}

	private void testNotEqualsBooleanTest() {
		assertNotEquals("testNotEqualsBooleanTest", true, false);
    }
}
