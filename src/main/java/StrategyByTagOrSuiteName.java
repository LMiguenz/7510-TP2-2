package main.java;

public class StrategyByTagOrSuiteName extends ExecutionStrategy {

	public StrategyByTagOrSuiteName(String tag, String testSuiteRegex) {
		super(new TagList(tag), "", testSuiteRegex);
	}

	@Override
	public void strategicExecution() {
		// TODO Auto-generated method stub
	}

}
