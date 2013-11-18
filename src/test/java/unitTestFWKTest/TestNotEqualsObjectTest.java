package unitTestFWKTest;
import unitTestFWK.TestMethod;



public class TestNotEqualsObjectTest extends TestMethod {

	public TestNotEqualsObjectTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		testNotEqualsObjectTest();
	}

	private void testNotEqualsObjectTest() {
		assertNotEquals("testNotEqualsObjectTest", "Hello", "ByeBye");
    }
}
