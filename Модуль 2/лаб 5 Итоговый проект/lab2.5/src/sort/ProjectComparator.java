package sort;

import java.util.Comparator;

import data.Project;

public class ProjectComparator implements Comparator<Project>{

	@Override
	public int compare(Project o1, Project o2) {
		if(o1.getPercentProjectCompletion()==o2.getPercentProjectCompletion()) {
			return 0;
		}
		else if(o1.getPercentProjectCompletion()<o2.getPercentProjectCompletion()) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
