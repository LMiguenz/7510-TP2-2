package main.java;

import java.util.regex.Pattern;

public class SelectionByTagsAndName extends SelectionTemplate {

	public SelectionByTagsAndName(TagList tags, String testCaseRegex) {
		super(tags, testCaseRegex, "");
	}
	
	@Override
	public boolean isSelected(Test test){
		if ( test.getTagList().getTags().contains(Test.suiteReservedTag) ){
			return true;
		}
		
		if ( !isRegexValid(testCaseRegex) ){
			return false;
		}
		
		return test.getTagList().containsAtLeastOneOf(tags)
		&& Pattern.matches(testCaseRegex, test.getName());
	}
	
}
