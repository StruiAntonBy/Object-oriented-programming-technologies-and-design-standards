package sort;

import java.util.Comparator;

import data.Requirement;

public class RequirementComparator implements Comparator<Requirement>{

	@Override
	public int compare(Requirement o1, Requirement o2) {
		if(o1.getPriority()==o2.getPriority()) {
			return 0;
		}
		else if(o1.getPriority()>o2.getPriority()) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
