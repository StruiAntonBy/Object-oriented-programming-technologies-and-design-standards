import java.io.File;

import parser.Parser;

public class Runner {

	public static void main(String[] args) {
		File file = new File("C:/Users/User/eclipse-workspace/lab 2.1/src/test.txt");
		Parser obj=new Parser();
		obj.parse(file);
	}

}
