package command;

import data.Variable;

public abstract class Command {
	public final static String Name="COMMAND";
	
	public static Variable getVariable() {
		return new Variable();
	}
	
	public static int getValue(Variable a) {
		return (int) a.getValue();
	}
}
