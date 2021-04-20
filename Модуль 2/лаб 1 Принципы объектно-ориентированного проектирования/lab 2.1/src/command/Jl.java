package command;

import data.Variable;

public class Jl extends Command{
	public static final String Name="JL";
	
	public static int getValue(Variable a,int specvar) {
		if(specvar==-1) {
			return (int) a.getValue();
		}
		else if(specvar==-10) {
			return -10;
		}
		return -1;
	}
}
