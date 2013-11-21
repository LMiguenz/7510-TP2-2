package unitTestFWK;

import java.util.HashMap;
import java.util.regex.Pattern;

public class SelectionByTagsOrTestName extends SelectionTemplate {

	public SelectionByTagsOrTestName(TagList tags, String testCaseRegex) {
		super(tags, testCaseRegex, "", new HashMap<String, TestResult>());
	}

	@Override
	public boolean isSelected(Test test) {
		if ( isSuite(test) ){
			return true;
		}
		
		if ( !isRegexValid(testCaseRegex) ){
			return false;
		}
		
		return test.getTagList().containsAtLeastOneOf(tags)
		|| Pattern.matches(testCaseRegex, test.getName());
	}

}
