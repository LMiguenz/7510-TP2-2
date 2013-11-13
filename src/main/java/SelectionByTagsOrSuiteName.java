package main.java;

public class SelectionByTagsOrSuiteName extends SelectionStrategy {

	public SelectionByTagsOrSuiteName(String tag, String testSuiteRegex) {
		super(new TagList(tag), "", testSuiteRegex);
	}

	@Override
	public boolean strategicSelection(Test test) {
		return false;
		// TODO Auto-generated method stub
	}

}
