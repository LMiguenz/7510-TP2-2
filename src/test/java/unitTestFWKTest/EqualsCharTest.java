package unitTestFWKTest;
import unitTestFWK.Affirm;
import unitTestFWK.TestMethod;


public class EqualsCharTest extends TestMethod {

	public EqualsCharTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		equalsCharTest();
	}
    
	private void equalsCharTest() {
        assertEquals("equalsCharTest", true, Affirm.checkEquals('a', 'a'));
        assertEquals("equalsCharTest", false, Affirm.checkEquals('a', 'b'));
    }
}
