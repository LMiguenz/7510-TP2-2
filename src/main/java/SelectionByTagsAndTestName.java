package main.java;

import java.util.regex.Pattern;

public class SelectionByTagsAndTestName extends SelectionTemplate {

	public SelectionByTagsAndTestName(TagList tags, String testCaseRegex) {
		super(tags, testCaseRegex, "");
	}
	
	@Override
	public boolean isSelected(Test test){
		if ( isSuite(test) ){
			return true;
		}
		
		if ( !isRegexValid(testCaseRegex) ){
			return false;
		}
		
		return test.getTagList().containsAtLeastOneOf(tags)
		&& Pattern.matches(testCaseRegex, test.getName());
	}
	
}
