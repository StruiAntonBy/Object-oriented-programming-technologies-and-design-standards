package command;

import data.Variable;

public class Mul extends Command{
	public static final String Name="MUL";
	
	public static Variable getVariable(Variable a,Variable b) {
		a.setValue(a.getValue()*b.getValue());
		return a;
	}
}
