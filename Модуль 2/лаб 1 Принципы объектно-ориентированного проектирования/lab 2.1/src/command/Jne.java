package command;

import data.Variable;

public class Jne extends Command{
	public static final String Name="JNE";
	
	public static int getValue(Variable a,int specvar) {
		if(specvar==-10) {
			return -10;
		}
		else if(specvar!=0) {
			return (int) a.getValue();
		}
		return -1;
	}
}
