
public class TestEqualsFloatTest extends TestMethod {

	public TestEqualsFloatTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		testEqualsFloatTest();
	}

	private void testEqualsFloatTest() {
		assertEquals("testEqualsFloatTest", 1.1, 1.1);
    }
}
