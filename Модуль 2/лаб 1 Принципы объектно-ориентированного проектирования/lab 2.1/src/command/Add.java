package command;

import data.Variable;

public class Add extends Command{
	public static final String Name="ADD";
	
	public static Variable getVariable(Variable a, Variable b) {
		a.setValue(a.getValue()+b.getValue());
		return a;
	}
}
