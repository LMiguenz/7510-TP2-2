package main.java;

//import main.java.Test;

public class SelectionByTags extends SelectionTemplate {

	public SelectionByTags(TagList tags) {
		super(tags, "", "");
	}
	
	@Override
	public boolean isSelected(Test test){
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
