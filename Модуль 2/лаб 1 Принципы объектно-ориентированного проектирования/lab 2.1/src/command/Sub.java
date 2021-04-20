package command;

import data.Variable;

public class Sub extends Command{
	public static final String Name="SUB";
	
	public static Variable getVariable(Variable a,Variable b) {
		a.setValue(a.getValue()-b.getValue());
		return a;
	}
}
