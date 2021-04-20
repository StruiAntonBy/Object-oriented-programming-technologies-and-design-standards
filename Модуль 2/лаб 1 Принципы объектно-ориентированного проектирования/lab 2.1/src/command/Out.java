package command;

public class Out extends Command{
	public final static String Name="OUT";
	
	public static void setValue(double Value) {
		System.out.println("Output data:"+Value);
	}
}
