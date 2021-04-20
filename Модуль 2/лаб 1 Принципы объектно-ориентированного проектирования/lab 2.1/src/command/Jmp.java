package command;

import data.Variable;

public class Jmp extends Command{
	public static final String Name="JMP";
	
	public static int getValue(Variable a) {
		return (int) a.getValue();
	}
}
