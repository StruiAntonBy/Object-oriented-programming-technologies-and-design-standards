package command;

import data.Variable;

public class Je extends Command{
	public static final String Name="JE";
	
	public static int getValue(Variable a, int specvar) {
		if(specvar==0) {
			return (int) a.getValue();
		}
		else if(specvar==-10) {
			return -10;
		}
		return -1;
	}
}
