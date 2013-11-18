package unitTestFWKTest;
import unitTestFWK.Affirm;
import unitTestFWK.TestMethod;


public class NotEqualsFloatTest extends TestMethod {

	public NotEqualsFloatTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		notEqualsFloatTest();
	}
	
    private void notEqualsFloatTest() {
        assertEquals("notEqualsFloatTest", true, Affirm.checkNotEquals(1.1, 1.2));
        assertEquals("notEqualsFloatTest", false, Affirm.checkNotEquals(1.1, 1.1));
    }

}