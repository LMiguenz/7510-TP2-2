package unitTestFWKTest;
import unitTestFWK.TestMethod;


public class TestNotEqualsFloatTest extends TestMethod {

	public TestNotEqualsFloatTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		testNotEqualsFloatTest();
	}

	private void testNotEqualsFloatTest() {
		assertNotEquals("testNotEqualsFloatTest", 1.1, 1.2);
    }
}
