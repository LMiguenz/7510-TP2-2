
public abstract class TestMethod extends Test {

	protected boolean skip;
	
	protected abstract void run();
	
	public TestMethod(String testName) {
		super(testName);
		tags = new TagList();
		skip = false;
	}

	@Override
	public void runTest() {
		long timeTestBegins = System.currentTimeMillis();
		try {
			run();
		} catch (Exception e) {
			setResult(new TestResultError(getName()));
		}
		setTimeElapsed(System.currentTimeMillis() - timeTestBegins);
		printer.printTest(this);
	}
	
	@Override
	public boolean isSetToSkip(){
		return skip;
	}
	
	public void addTag(String tag){
		if(tag != suiteReservedTag){
			tags.add(tag);
		}
	}
	
	public void removeTag(String tag){
		tags.remove(tag);
	}
	
	public void setToSkip(){
		skip = true;
	}
	
	public void setNotToSkip(){
		skip = false;
	}
}
