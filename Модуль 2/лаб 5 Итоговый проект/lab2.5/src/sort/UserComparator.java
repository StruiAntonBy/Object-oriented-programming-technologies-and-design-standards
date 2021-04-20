package sort;

import java.util.Comparator;

import data.User;

public class UserComparator implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		if(o1.getRole()==o2.getRole()) {
			return 0;
		}
		else if(o1.getRole()<o2.getRole()) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
