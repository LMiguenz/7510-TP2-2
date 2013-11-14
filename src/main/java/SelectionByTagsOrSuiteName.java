package main.java;

public class SelectionByTagsOrSuiteName extends SelectionTemplate {

	public SelectionByTagsOrSuiteName(String tag, String testSuiteRegex) {
		super(new TagList(tag), "", testSuiteRegex);
	}

	@Override
	public boolean isSelected(Test test) {
		return false;
		// TODO Auto-generated method stub
	}

}
