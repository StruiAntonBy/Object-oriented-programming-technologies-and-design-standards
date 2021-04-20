package command;

import data.Variable;

public class Jng extends Command{
	public static final String Name="JNG";
	
	public static int getValue(Variable a,int specvar) {
		if(specvar==-10) {
			return -10;
		}
		else if(specvar!=1) {
			return (int) a.getValue();
		}
		return -1;
	}
}
