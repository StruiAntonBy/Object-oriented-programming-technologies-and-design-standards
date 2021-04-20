package command;

import data.Variable;

public class Mov extends Command{
	public final static String Name="MOV";
	
	public static Variable getVariable(Variable a,Variable b) {
		a.setValue(b.getValue());
		return a;
	}
}
