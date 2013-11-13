package main.java;

public class SelectionByTagsAndName extends SelectionStrategy {

	public SelectionByTagsAndName(TagList tags, String testCaseRegex) {
		super(tags, testCaseRegex, "");
	}
	
	@Override
	public boolean strategicSelection(Test test){
		return false;
		// TODO Auto-generated method stub
	}

}
