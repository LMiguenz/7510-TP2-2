package unitTestFWK;

import java.util.Collection;

import javax.xml.transform.TransformerException;

public class TestRunner {

	private ResultPrinter printer;
	private String fileXMLhistoryName = "default.xml";

	public TestRunner() {
		printer = new CmdLineResultPrinter();
	}

	public void startTesting(TestSuite testSuite) {
		testSuite.setPrinter(printer);
		long timeTestBegins = System.currentTimeMillis();
		testSuite.runTest();
		testSuite.setTimeElapsed(System.currentTimeMillis() - timeTestBegins);
		testSuite.getPrinter().printSummary();

		XMLResultHistory history = new XMLResultHistory(fileXMLhistoryName);
		Collection<Test> tests = testSuite.getTests();
		for (Test test : tests) {
			history.saveResults(test);
		}
		try {
			history.generateDocument();
		}
		catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public void useThisResultPrinter(ResultPrinter rp) {
		if (rp != null) {
			printer = rp;
		}
	}

	/* Setea el archivo storage que se desea utilizar */
	public void setXMLHistoryFileName(String fileName) {
		fileXMLhistoryName = fileName;
	}
}
