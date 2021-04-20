package data;

public class Variable implements VariableInterface{
	
	private String Name;
	private double Value;

	public String getName() {
		return Name;
	}

	public double getValue() {
		return Value;
	}

	public boolean setName(String Name) {
		if(correctName(Name)) {
			this.Name=Name;
			return true;
		}
		else {
			return false;
		}
	}

	public void setValue(double Value) {
		this.Value=Value;
	}
	
	public static boolean correctName(String Name) {
		return Name.matches("^[a-zA-Z]+$");
	}

}
