package unitTestFWK;

import java.util.HashMap;

public class SelectionByTestResult extends SelectionTemplate {

		public SelectionByTestResult(HashMap<String, TestResult> xml) {
			super(new TagList() , "", "", xml);
		}

		@Override
		public boolean isSelected(Test test){
			boolean validate = true;

			if (xml.containsKey(test.getName())){
				if ( test.getResult().getCodigo() != "OK"){
					validate = true;
				}else{
					validate = false;
				}
			}
			return validate;
		}
		
	}
