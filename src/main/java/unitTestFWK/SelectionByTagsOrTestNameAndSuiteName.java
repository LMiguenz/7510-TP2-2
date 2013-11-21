package unitTestFWK;

import java.util.HashMap;
import java.util.regex.Pattern;

public class SelectionByTagsOrTestNameAndSuiteName extends SelectionTemplate {

	public SelectionByTagsOrTestNameAndSuiteName(TagList tags,
			String testCaseRegex, String testSuiteRegex) {
		super(tags, testCaseRegex, testSuiteRegex, new HashMap<String, TestResult>());
	}

	@Override
	public boolean isSelected(Test test) {
		if ( isSuite(test) ){
			return true;
		}
		
		if (!isRegexValid(testCaseRegex) ||  !isRegexValid(testSuiteRegex) ){
			return false;
		}
		
		boolean tagsOK = false;
		if( test.getTagList().containsAtLeastOneOf(tags) ){
			tagsOK = true;
		}
		
		boolean testOK = Pattern.matches(testCaseRegex, test.getName());
		
		boolean suiteOK = false;
		for( String suiteName : test.getSuites() ){
			if( Pattern.matches(testSuiteRegex, suiteName) ){
				suiteOK = true;
				break;
			}
		}
		
		return tagsOK || testOK && suiteOK;
	}

}
