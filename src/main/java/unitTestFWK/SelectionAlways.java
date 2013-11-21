package unitTestFWK;

import java.util.HashMap;

public class SelectionAlways extends SelectionTemplate {

	public SelectionAlways() {
		super(new TagList(), "", "", new HashMap<String, TestResult>());
	}

	@Override
	public boolean isSelected(Test test) {
		return true;
	}

}
