package unitTestFWK;

import java.util.HashMap;

public class SelectionByTestResult extends SelectionTemplate {

	public SelectionByTestResult(HashMap<String, TestResult> hashStorage) {
		super(new TagList(), "", "", hashStorage);
	}

	@Override
	public boolean isSelected(Test test) {
		if (hash.containsKey(test.getName())) {
			TestResult result = hash.get(test.getName());
			if (result.getCode() == TestResultOk.TEST_CODE) {
				return false;
			}
		}
		return true;
	}
}