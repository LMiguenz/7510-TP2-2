package main.java;

public class SelectionByTagsAndName extends SelectionTemplate {

	public SelectionByTagsAndName(TagList tags, String testCaseRegex) {
		super(tags, testCaseRegex, "");
	}
	
	@Override
	public boolean isSelected(Test test){
		return false;
		// TODO Auto-generated method stub
	}

}
