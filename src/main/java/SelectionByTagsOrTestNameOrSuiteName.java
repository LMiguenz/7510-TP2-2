
import java.util.regex.Pattern;

public class SelectionByTagsOrTestNameOrSuiteName extends SelectionTemplate {

	public SelectionByTagsOrTestNameOrSuiteName(TagList tags,
			String testCaseRegex, String testSuiteRegex) {
		super(tags, testCaseRegex, testSuiteRegex);
	}

	@Override
	public boolean isSelected(Test test) {
		if ( isSuite(test) ){
			return true;
		}
		
		if ( !isRegexValid(testCaseRegex) || !isRegexValid(testSuiteRegex) ){
			return false;
		}
		
		if( test.getTagList().containsAtLeastOneOf(tags) ){
			return true;
		}
		
		if( Pattern.matches(testCaseRegex, test.getName()) ){
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
