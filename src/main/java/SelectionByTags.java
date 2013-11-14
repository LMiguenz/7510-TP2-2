package main.java;

//import main.java.Test;

public class SelectionByTags extends SelectionStrategy {

	public SelectionByTags(TagList tags) {
		super(tags, "", "");
	}
	
	@Override
	public boolean strategicSelection(Test test){
		if ( test.getTagList().getTags().contains(Test.suiteReservedTag) ){
			return true;
		}
		
		TagList testTagList = test.getTagList();
		for (String tag : tags.getTags()){
			if (testTagList.getTags().contains(tag)){
				return true;
			}
		}
		
		return false;
	}
}
