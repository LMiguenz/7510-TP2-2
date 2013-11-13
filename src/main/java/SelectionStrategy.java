package main.java;

public abstract class SelectionStrategy {

	protected TagList tags;
	protected String testCaseRegex;
	protected String testSuiteRegex;
	
	public SelectionStrategy(TagList tags, String testCaseRegex, String testSuiteRegex){
		this.tags = tags;
		this.testCaseRegex = testCaseRegex;
		this.testSuiteRegex = testSuiteRegex;
	}
	
	public abstract boolean strategicSelection(Test test);
}
