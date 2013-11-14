package test.java;

import main.java.Affirm;
import main.java.TestMethod;

public class EqualsIntTest extends TestMethod {

	public EqualsIntTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		equalsIntTest();
	}
    
	private void equalsIntTest() {
        assertEquals("equalsIntTest", true, Affirm.checkEquals(1, 1));
        assertEquals("equalsIntTest" ,false, Affirm.checkEquals(1, 2));
    }
}
