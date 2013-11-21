package unitTestFWK;

import java.util.HashMap;

public abstract class SelectionTemplate {

	protected TagList tags;
	protected String testCaseRegex;
	protected String testSuiteRegex;
	protected HashMap<String, TestResult> hash;

	public SelectionTemplate(TagList tags, String testCaseRegex,
			String testSuiteRegex, HashMap<String, TestResult> storageHash) {
		this.tags = tags;
		this.testCaseRegex = testCaseRegex;
		this.testSuiteRegex = testSuiteRegex;
		hash = storageHash;
	}

	public abstract boolean isSelected(Test test);

	protected boolean isRegexValid(String regex) {
		return (regex != "") && (regex != null);
	}

	protected boolean isSuite(Test test) {
		return test.getTagList().getTags().contains(Test.suiteReservedTag);
	}
}