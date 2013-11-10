package main.java;

public class StrategyByTag extends ExecutionStrategy {

	public StrategyByTag(String tag) {
		super(new TagList(tag), "", "");
	}
	
	@Override
	public void strategicExecution(){
		//acá habría que poner el código que ahora está en el run de testSuite,
		//modificado para que consulte el tag antes de correrlo, y que testSuite
		//se limite a ejecutar la estrategia que corresponda. El usuario puede 
		//setear la estrategia al crear las suites en el main de pruebas.
		//(Ídem para las demás estrategias)
	}
}
