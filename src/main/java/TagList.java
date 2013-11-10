package main.java;

import java.util.HashSet;

public class TagList {
		
	private HashSet<String> tags;
	
	public TagList(){
		tags = new HashSet<String>();
	}
	
	public TagList(String tag){
		tags = new HashSet<String>();
		tags.add(tag.toUpperCase());
	}
	
	public void add(String tag){
		tags.add(tag.toUpperCase());
	}
	
	public void remove(String tag){
		tags.remove(tag.toUpperCase());
	}
	
	public HashSet<String> getTags(){
		return tags;
	}
}
