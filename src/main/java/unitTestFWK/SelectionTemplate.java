package unitTestFWK;

import java.util.HashMap;

public abstract class SelectionTemplate {

	protected TagList tags;
	protected String testCaseRegex;
	protected String testSuiteRegex;
	protected HashMap<String, TestResult> xml;
	
	public SelectionTemplate(TagList tags, String testCaseRegex, String testSuiteRegex, HashMap<String, TestResult> xml){
		this.tags = tags;
		this.testCaseRegex = testCaseRegex;
		this.testSuiteRegex = testSuiteRegex;
		this.xml = xml;
	}
	
	public abstract boolean isSelected(Test test);
	
	protected boolean isRegexValid(String regex){
		return (regex != "") && (regex != null);
	}
	
	protected boolean isSuite(Test test){
		return test.getTagList().getTags().contains(Test.suiteReservedTag);
	}
}
