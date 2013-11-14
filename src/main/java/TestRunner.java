package main.java;

import javax.xml.parsers.ParserConfigurationException;

public class TestRunner {
	
	private ResultPrinter printer;
	private String pattern;
	
	public TestRunner() {
		printer = new CmdLineResultPrinter();
		pattern = null;
	}
	
	public void startTesting(TestSuite testSuite) {
		testSuite.setPrinter(printer);
		testSuite.usePattern(pattern);
		long timeTestBegins = System.currentTimeMillis();
		testSuite.runTest();
		testSuite.setTimeElapsed(System.currentTimeMillis() - timeTestBegins);
		testSuite.getPrinter().printSummary();
	}
	
	public void useXMLResultPrinter() throws ParserConfigurationException {
		this.printer = new XMLResultPrinter();
	}
	
	public void useCmdLineResultPrinter() throws ParserConfigurationException {
		this.printer = new CmdLineResultPrinter();
	}
	
	public void usePattern(String aPattern){
		if (aPattern != "") {
			pattern = aPattern;
		}
	}
}
