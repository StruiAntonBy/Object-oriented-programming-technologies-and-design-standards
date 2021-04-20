package command;

import data.Variable;

public class Jg extends Command{
	public static final String Name="JG";
	
	public static int getValue(Variable a,int specvar) {
		if(specvar==1) {
			return (int) a.getValue();
		}
		else if(specvar==-10) {
			return -10;
		}
		return -1;
	}
}
