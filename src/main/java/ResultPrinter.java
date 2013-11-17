/**
 * This class works as the user visual interface of the testing framework, 
 * printing the report of the tests executed and their results
 * 
 * @author Miguenz, Rodriguez, Suárez
 *
 */

import java.util.ArrayList;

public abstract class ResultPrinter {

	protected String SEPARATOR = "----------------";
	protected String DOUBLE_SEPARATOR = "================";
	protected String SUMMARY_HDR = "[failure] Summary";
	protected String suiteName;
	protected ArrayList<String> buffer;
	protected int failedTests;
	protected int errorTests;
	protected int okTests;
	
	public ResultPrinter() {
		suiteName = "";
		failedTests = 0;
		errorTests = 0;
		okTests = 0;
		buffer = new ArrayList<String>();
	}

	public abstract void printTest(Test test);
	
	public abstract void printSuite(TestSuite suite);
	
	public abstract void removeSuite(TestSuite suite);
	
	public abstract void printSummary();
	
	public void oneMoreTestFailed() {
		failedTests++;
	}

	public void oneMoreTestOk() {
		okTests++;
	}
	
	public void oneMoreTestErrored() {
		errorTests++;
	}
}
