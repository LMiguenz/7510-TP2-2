package test.java;

import main.java.TestMethod;

public class TestEqualsCharTest extends TestMethod {

	public TestEqualsCharTest(String newName) {
		super(newName);
	}

	@Override
	public void run() {
		testEqualsCharTest();
	}

	private void testEqualsCharTest() {
		assertEquals("testEqualsCharTest", 'a', 'a');
    }
}
