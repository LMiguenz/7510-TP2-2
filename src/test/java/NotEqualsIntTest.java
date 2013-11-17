
public class NotEqualsIntTest extends TestMethod {

	public NotEqualsIntTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		notEqualsIntTest();
	}
	
    private void notEqualsIntTest() {
        assertEquals("notEqualsIntTest", true, Affirm.checkNotEquals(1, 2));
        assertEquals("notEqualsIntTest", false, Affirm.checkNotEquals(1, 1));
    }

}
