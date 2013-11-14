package test.java;

import main.java.Affirm;
import main.java.TestMethod;

public class EqualsObjectTest extends TestMethod {

	public EqualsObjectTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		equalsObjectTest();
	}

	private void equalsObjectTest() {
        assertEquals("equalsObjectTest", true, Affirm.checkEquals("Hello", "Hello"));
        assertEquals("equalsObjectTest", false, Affirm.checkEquals("Hello", "ByeBye"));
    }
}
