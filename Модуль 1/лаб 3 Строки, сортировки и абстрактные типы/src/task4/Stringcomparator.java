package task4;

import java.util.Comparator;

public class Stringcomparator implements Comparator<String>{
	public int compare(String s1,String s2) {
		if(s1.length()>s2.length()) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
