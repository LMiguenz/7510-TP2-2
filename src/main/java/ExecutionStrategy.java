package main.java;

public abstract class ExecutionStrategy {

	protected TagList tags;
	protected String testCaseRegex;
	protected String testSuiteRegex;
	
	public ExecutionStrategy(TagList tags, String testCaseRegex, String testSuiteRegex){
		this.tags = tags;
		this.testCaseRegex = testCaseRegex;
		this.testSuiteRegex = testSuiteRegex;
	}
	
	public abstract void strategicExecution();
}
