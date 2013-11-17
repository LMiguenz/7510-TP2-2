
public class SelectionAlways extends SelectionTemplate {

	public SelectionAlways() {
		super(new TagList(), "", "");
	}

	@Override
	public boolean isSelected(Test test) {
		return true;
	}

}
