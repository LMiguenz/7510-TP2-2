package unitTestFWK;

public abstract class TestMethod extends Test {

	protected boolean skip;
	protected long timeLimit;

	protected abstract void run();

	public TestMethod(String testName) {
		super(testName);
		timeLimit = 0;
		tags = new TagList();
		skip = false;
	}

	@Override
	public void runTest() {
		long timeTestBegins = System.currentTimeMillis();
		try {
			run();
		}
		catch (Exception e) {
			setResult(new TestResultError(getName()));
		}
		setTimeElapsed(System.currentTimeMillis() - timeTestBegins);
		if (hasTimeLimit() && (getTimeElapsed() > getTimeLimit())) {
			System.out.println("\n!!!TIME ELAPSED TOO LONG!!!");
			setResult(new TestResultFail(getName()));
		}
		printer.printTest(this);
	}

	@Override
	public boolean isSetToSkip() {
		return skip;
	}

	public void addTag(String tag) {
		if (tag != suiteReservedTag) {
			tags.add(tag);
		}
	}

	public void removeTag(String tag) {
		tags.remove(tag);
	}

	public void setToSkip() {
		skip = true;
	}

	public void setNotToSkip() {
		skip = false;
	}

	public void setTimeLimit(long timeInMilliseconds) {
		timeLimit = timeInMilliseconds;
	}

	public long getTimeLimit() {
		return timeLimit;
	}

	public void setNoTimeLimit() {
		timeLimit = 0;
	}

	public boolean hasTimeLimit() {
		return timeLimit > 0;
	}
}
