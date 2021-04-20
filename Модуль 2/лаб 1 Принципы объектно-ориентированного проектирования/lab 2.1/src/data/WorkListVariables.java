package data;

import java.util.ArrayList;

public final class WorkListVariables{
	public static int getIndex(ArrayList<Variable> variables,String Name) {
		for(int i=0;i<variables.size();i++) {
			if(variables.get(i).getName().equals(Name)) {
				return i;
			}
		}
		return -1;
	}
}
