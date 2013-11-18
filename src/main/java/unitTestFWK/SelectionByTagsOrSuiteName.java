package unitTestFWK;

import java.util.regex.Pattern;

public class SelectionByTagsOrSuiteName extends SelectionTemplate {

	public SelectionByTagsOrSuiteName(TagList tags, String testSuiteRegex) {
		super(tags, "", testSuiteRegex);
	}

	@Override
	public boolean isSelected(Test test) {
		if ( isSuite(test) ){
			return true;
		}
		
		if ( !isRegexValid(testSuiteRegex) ){
			return false;
		}
		
		if( test.getTagList().containsAtLeastOneOf(tags) ){
			return true;
		}
		
		for( String suiteName : test.getSuites() ){
			if( Pattern.matches(testSuiteRegex, suiteName) ){
				return true;
			}
		}
		return false;
	}

}
