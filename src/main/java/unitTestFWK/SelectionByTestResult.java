package unitTestFWK;

import java.util.HashMap;

public class SelectionByTestResult extends SelectionTemplate {

		public SelectionByTestResult(HashMap<String, TestResult> xml) {
			super(new TagList() , "", "", xml);
		}

		@Override
		public boolean isSelected(Test test){
			TestResultOk esperado = new TestResultOk("T1");
			TestResult actual = xml.get(test.getName());
			boolean validate = true;

			if (xml.containsKey(test.getName())){
				if ( actual.getTestName() != esperado.getTestName()){
					validate = true;
				}else{
					validate = false;
				}
			}
			return validate;
		}
		
	}
