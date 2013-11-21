package unitTestFWK;


/** This class collects the result of a test and shows the result
 * using ResultBoard class.
 * 
 * @author Miguenz, Rodriguez, Suárez */
public abstract class TestResult {

	protected String testName;
	protected String cod;

	public TestResult(String testName) {
		this.testName = testName;
		this.cod = "OK";
	}

	public String print() {
		return "";
	}
	
	public void setCodigo(String cod){
		this.cod = cod;
	}

	public String getCodigo() {
		return cod;
	}
	
	public String getTestName() {
		return testName;
	}

	public abstract void updateMe(ResultPrinter printer);

	public abstract String getCode();
}
