
public class NotEqualsBooleanTest extends TestMethod {

	public NotEqualsBooleanTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		notEqualsBooleanTest();
	}
	
    private void notEqualsBooleanTest() {
    	assertEquals("notEqualsBooleanTest", true, Affirm.checkNotEquals(true, false));
        assertEquals("notEqualsBooleanTest", false, Affirm.checkNotEquals(true, true));
    }
}
