package task4;

import java.util.Comparator;

public class StringCompatator implements Comparator<String>{
	String substring1;
	String substring2;
	
	StringCompatator(String substring1,String substring2){
		this.substring1=substring1;
		this.substring2=substring2;
	}
	
	public int compare(String s1, String s2) {
		int start1=s1.indexOf(substring1);
		int end1=s1.lastIndexOf(substring2);
		int start2=s2.indexOf(substring1);
		int end2=s2.lastIndexOf(substring2);
		String S1=s1.substring(start1,end1);
		String S2=s2.substring(start2,end2);
        return S1.compareToIgnoreCase(S2);
    }
	
}