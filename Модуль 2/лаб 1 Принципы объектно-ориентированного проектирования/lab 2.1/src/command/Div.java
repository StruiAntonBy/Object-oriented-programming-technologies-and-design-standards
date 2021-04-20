package command;

import data.Variable;

public class Div extends Command{
	public static final String Name="DIV";
	
	public static Variable getVariable(Variable a,Variable b) {
		a.setValue(a.getValue()/b.getValue());
		return a;
	}
}
