package unitTestFWK;

import java.util.HashMap;

public class SelectionByTestResult extends SelectionTemplate {

	public SelectionByTestResult(HashMap<String, TestResult> hashStorage) {
		super(new TagList(), "", "", hashStorage);
	}

	@Override
	public boolean isSelected(Test test) {
		if (hash.containsKey(test.getName())
				&& test.getResult().getCode() != TestResult.TEST_OK_CODE) {
			return true;
		}
		return false;
	}
}