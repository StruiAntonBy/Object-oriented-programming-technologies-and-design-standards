package command;

import data.Variable;

public class Jnl extends Command{
	public static final String Name="JNL";
	
	public static int getValue(Variable a,int specvar) {
		if(specvar==-10) {
			return -10;
		}
		else if(specvar!=-1) {
			return (int) a.getValue();
		}
		return -1;
	}
}
