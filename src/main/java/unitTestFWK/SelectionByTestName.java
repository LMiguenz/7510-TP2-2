package unitTestFWK;

import java.util.HashMap;
import java.util.regex.Pattern;

public class SelectionByTestName extends SelectionTemplate {

	public SelectionByTestName(String testCaseRegex) {
		super(new TagList(), testCaseRegex, "", new HashMap<String, TestResult>());
	}

	@Override
	public boolean isSelected(Test test) {
		if ( isSuite(test) ){
			return true;
		}
		
		if ( !isRegexValid(testCaseRegex) ){
			return false;
		}
		
		return Pattern.matches(testCaseRegex, test.getName());
	}

}
