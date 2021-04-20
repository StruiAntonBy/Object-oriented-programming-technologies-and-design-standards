package task2;

public class input_and_output {

	public static void main(String[] args) {
		list List=inputData.input();
		if (List==null) {
			return;
		}
		List.allShow();
		algorithm.alg(List);
		List.allShow();
	}
	
}
