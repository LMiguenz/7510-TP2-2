package main.java;

import java.util.Collection;
import java.util.HashMap;
import java.util.regex.Pattern;
import main.java.TestExistsException;

public class TestSuite extends Test {

	private HashMap<String,Test> tests;
	private ResultPrinter printer;
	private SelectionStrategy strategy;

	public TestSuite (String newName, ResultPrinter aPrinter) {
		super(newName);
		tests = new HashMap<String, Test>();
		tags = new TagList(suiteReservedTag);
		strategy = new SelectionAlways();
		printer = aPrinter;
	}
	
	@Override
	public void runTest() {
		
		printer.printSuite(this);
		setUp();
		long timeTestBegins = System.currentTimeMillis();
		Collection<Test> col = tests.values();

		for (Test test : col) {
			if (mustBeRun(test)) {
				runSubTest(test);
			}
		}
		
		this.timeElapsed = (System.currentTimeMillis() - timeTestBegins);
		tearDown();
		printer.removeSuite(this);
	}

	public void runTest(String pattern) {
		
		//if (mustBeRun(this)) {
		printer.printSuite(this);
		setUp();
		long timeTestBegins = System.currentTimeMillis();

		Collection<Test> col = tests.values();

		for (Test test : col) {
			if (Pattern.matches(pattern, test.getName()) && mustBeRun(test)) {
				runSubTest(test);
			}
		}
		this.timeElapsed = (System.currentTimeMillis() - timeTestBegins);
		tearDown();
		printer.removeSuite(this);
		//}

	}
	
	public void addTest(Test test) throws TestExistsException {
		if (!tests.containsKey(test.getName())) {
			tests.put(test.getName(), test);
		}
		else { 
			throw new TestExistsException(test.getName() 
					+ " already present in TestSuite "
					+ this.getName()); 
		}
	}
	
	@Override
	public boolean isSetToSkip(){
		return false;
	}

	public ResultPrinter getPrinter() {
		return printer;
	}
	
	public void setToRunByTag(String tag){
		strategy = new SelectionByTags(new TagList(tag));
	}
	
	public Collection<Test> getTests(){
		return this.tests.values();
	}
	
	public boolean mustBeRun(Test test){
		return !test.isSetToSkip() && strategy.strategicSelection(test);
	}

	private void runSubTest(Test test) {
		test.setUp();
		test.setPrinter(printer);
		test.runTest();
		test.tearDown();
	}
}
