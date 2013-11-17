
public class TestEqualsObjectTest extends TestMethod {

	public TestEqualsObjectTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		testEqualsObjectTest();
	}

	private void testEqualsObjectTest() {
		assertEquals("testEqualsObjectTest", "Hello", "Hello");
    }
}
