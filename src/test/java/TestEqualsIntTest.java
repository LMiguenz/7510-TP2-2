
public class TestEqualsIntTest extends TestMethod {

	public TestEqualsIntTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		testEqualsIntTest();
	}

	private void testEqualsIntTest() {
		assertEquals("testEqualsIntTest", 1, 1);
    }
}
