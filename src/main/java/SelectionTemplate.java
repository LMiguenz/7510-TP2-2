package main.java;

public abstract class SelectionTemplate {

	protected TagList tags;
	protected String testCaseRegex;
	protected String testSuiteRegex;
	
	public SelectionTemplate(TagList tags, String testCaseRegex, String testSuiteRegex){
		this.tags = tags;
		this.testCaseRegex = testCaseRegex;
		this.testSuiteRegex = testSuiteRegex;
	}
	
	public abstract boolean isSelected(Test test);
}
