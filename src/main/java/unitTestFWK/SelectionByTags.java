package unitTestFWK;

import java.util.HashMap;
//import main.java.Test;

public class SelectionByTags extends SelectionTemplate {

	public SelectionByTags(TagList tags) {
		super(tags, "", "", new HashMap<String, TestResult>());
	}
	
	@Override
	public boolean isSelected(Test test){
		if ( test.getTagList().getTags().contains(Test.suiteReservedTag) ){
			return true;
		}
		
		if( test.getTagList().containsAtLeastOneOf(tags) ){
			return true;
		}
		return false;
	}
}
