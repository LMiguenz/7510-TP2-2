package unitTestFWK;

import java.util.Collection;
import java.util.HashMap;

public class MemoryHashStorage implements Storage {
	private HashMap<String, TestResult> hash;

	public MemoryHashStorage() {
		hash = new HashMap<String, TestResult>();
	}

	@Override
	public boolean storeSuiteResults(TestSuite suite) {
		Collection<Test> tests = suite.getTests();
		for (Test test : tests) {
			hash.put(test.getName(), test.getResult());
		}
		return true;
	}

	@Override
	public HashMap<String, TestResult> restoreSuiteResults() {
		return hash;
	}
}