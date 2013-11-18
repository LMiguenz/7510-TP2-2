package unitTestFWK;

import java.util.regex.Pattern;

public class SelectionByTagsAndSuiteName extends SelectionTemplate {

	public SelectionByTagsAndSuiteName(TagList tags, String testSuiteRegex) {
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
		
		boolean tagsOK = false;
		if( test.getTagList().containsAtLeastOneOf(tags) ){
			tagsOK = true;
		}
		
		boolean suiteOK = false;
		for( String suiteName : test.getSuites() ){
			if( Pattern.matches(testSuiteRegex, suiteName) ){
				suiteOK = true;
				break;
			}
		}
		
		return tagsOK && suiteOK;
	}

}
