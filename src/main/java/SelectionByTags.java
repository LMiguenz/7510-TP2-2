package main.java;

public class SelectionByTags extends SelectionStrategy {

	public SelectionByTags(TagList tags) {
		super(tags, "", "");
	}
	
	@Override
	public boolean strategicSelection(Test test){
		if ( test.getTagList().getTags().contains("") ){
			return true;
		}
		if ( test.getTagList().getTags().containsAll(tags.getTags()) ){
			return true;
		}
		return false;
	}
}
