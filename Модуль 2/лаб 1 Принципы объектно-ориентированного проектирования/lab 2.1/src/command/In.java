package command;

import java.util.Scanner;

public final class In extends Command{
	
	private static Scanner in;
	public static final String Name = "IN";

	public static double getValue() {
		in = new Scanner(System.in);
        System.out.print("Input a number:");
        double num = in.nextDouble();
        return num;
	}
	
}
