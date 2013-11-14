package test.java;

import main.java.Affirm;
import main.java.TestMethod;

public class EqualsCharTest extends TestMethod {

	public EqualsCharTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		equalsCharTest();
	}
    
	private void equalsCharTest() {
        assertEquals("equalsCharTest", true, Affirm.checkEquals('a', 'a'));
        assertEquals("equalsCharTest", false, Affirm.checkEquals('a', 'b'));
    }
}
