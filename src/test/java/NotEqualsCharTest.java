
public class NotEqualsCharTest extends TestMethod {

	public NotEqualsCharTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		notEqualsCharTest();
	}
	
    private void notEqualsCharTest() {
        assertEquals("notEqualsCharTest", true, Affirm.checkNotEquals('a', 'b'));
        assertEquals("notEqualsCharTest", false, Affirm.checkNotEquals('a', 'a'));
    }

}
