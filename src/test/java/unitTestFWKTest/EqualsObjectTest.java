package unitTestFWKTest;
import unitTestFWK.Affirm;
import unitTestFWK.TestMethod;


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
