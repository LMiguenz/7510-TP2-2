package unitTestFWK;

import java.util.HashMap;

public interface Storage {

	/* Stores the results of a test suite in a user defined structure */
	public boolean storeSuiteResults(TestSuite suite);

	/* Returns the data stored in a HashMap, with the test name being the key */
	public HashMap<String, TestResult> restoreSuiteResults();
}
