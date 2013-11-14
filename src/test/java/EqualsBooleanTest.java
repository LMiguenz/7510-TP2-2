package test.java;

import main.java.Affirm;
import main.java.TestMethod;

public class EqualsBooleanTest extends TestMethod {

	public EqualsBooleanTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		equalsBooleanTest();
	}

	private void equalsBooleanTest() {
		assertEquals("equalsBooleanTest", true, Affirm.checkEquals(true, true));
        assertEquals("equalsBooleanTest", false, Affirm.checkEquals(true, false));
    }

}
