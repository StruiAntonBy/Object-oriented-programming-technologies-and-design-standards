package task4;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer>{
	public int compare(Integer n1,Integer n2) {
		if(n1>n2) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
