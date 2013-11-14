package test.java;

import main.java.TestMethod;

public class TestNotEqualsCharTest extends TestMethod {

	public TestNotEqualsCharTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		testNotEqualsCharTest();
	}

	private void testNotEqualsCharTest() {
		assertNotEquals("testNotEqualsCharTest", 'a', 'b');
    }
}
