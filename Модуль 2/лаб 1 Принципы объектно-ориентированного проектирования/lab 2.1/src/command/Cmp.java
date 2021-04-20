package command;

import data.Variable;

public class Cmp extends Command{
	public static final String Name="CMP";
	
	public static int getSpecVar(Variable a,Variable b) {
		if(a.getValue()>b.getValue()) {
			return 1;
		}
		else if(a.getValue()==b.getValue()) {
			return 0;
		}
		else {
			return -1;
		}
	}
}
