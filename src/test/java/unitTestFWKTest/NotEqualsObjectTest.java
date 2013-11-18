package unitTestFWKTest;
import unitTestFWK.Affirm;
import unitTestFWK.TestMethod;


public class NotEqualsObjectTest extends TestMethod {

	public NotEqualsObjectTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		notEqualsObjectTest();
	}

    private void notEqualsObjectTest() {
        assertEquals("notEqualsObjectTest", true, Affirm.checkNotEquals("Hello", "ByeBye"));
        assertEquals("notEqualsObjectTest", false, Affirm.checkNotEquals("Hello", "Hello"));
    }
}
