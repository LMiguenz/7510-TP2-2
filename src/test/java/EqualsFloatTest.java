package test.java;

import main.java.Affirm;
import main.java.TestMethod;

public class EqualsFloatTest extends TestMethod {

	public EqualsFloatTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		equalsFloatTest();
	}
    
	private void equalsFloatTest() {
        assertEquals("equalsFloatTest", true, Affirm.checkEquals(1.1, 1.1));
        assertEquals("equalsFloatTest" ,false, Affirm.checkEquals(1.1, 1.2));
    }
}
