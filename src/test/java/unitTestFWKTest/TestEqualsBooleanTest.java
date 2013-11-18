package unitTestFWKTest;
import unitTestFWK.TestMethod;


public class TestEqualsBooleanTest extends TestMethod {

	public TestEqualsBooleanTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		testEqualsBooleanTest();
	}

	private void testEqualsBooleanTest() {
		assertEquals("testEqualsBooleanTest", "Hello", "Hello");
    }
}
