package main.java;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.regex.Pattern;
import main.java.TestExistsException;

public class TestSuite extends Test {

	private HashMap<String,Test> tests;
	private ResultPrinter printer;
	private ExecutionStrategy strategy;

	public TestSuite (String newName, ResultPrinter aPrinter) {
		super(newName);
		tests = new HashMap<String, Test>();
		printer = aPrinter;
	}
	
	@Override
	public void runTest() {
		printer.printSuite(this);
		setUp();
		long timeTestBegins = System.currentTimeMillis();
		long timeSubTestBegins = 0;
		Collection<Test> col = tests.values();

		for (Test test : col) {
			test.setUp();
			timeSubTestBegins = System.currentTimeMillis();
			try {
				test.runTest();
				
			} catch (Exception e) {
				test.setResult(new TestResultError(test.getName()));
			}
			test.setTimeElapsed(System.currentTimeMillis() - timeSubTestBegins);
			test.tearDown();
			
			printer.printTest(test);
		}
		this.timeElapsed = (System.currentTimeMillis() - timeTestBegins);
		tearDown();
		printer.removeSuite(this);
	}

	public void runTest(String pattern) {
		setUp();
		
		Collection<Test> col = tests.values();

		for (Test test : col) {
			if (Pattern.matches(pattern, test.getName())) {
				test.setUp();
				test.runTest();
				test.tearDown();
			}
		}

		tearDown();
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

	public ResultPrinter getPrinter() {
		return printer;
	}

}
