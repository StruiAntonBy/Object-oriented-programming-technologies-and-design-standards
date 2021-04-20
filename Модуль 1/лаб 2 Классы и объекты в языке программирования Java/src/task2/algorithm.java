package task2;

public class algorithm {
	
	public static void subtask(list List,char operation) {
		top next=List.getStart();
		while(next!=null) {
			if (next.getnextOperation()==operation) {
				if (operation=='+') {
					next.setElem(next.getElem()+next.getnextTop().getElem());
				}
				else if(operation=='*') {
					next.setElem(next.getElem()*next.getnextTop().getElem());
				}
				next.setnextOperation(next.getnextTop().getnextOperation());
				next.setnextTop(next.getnextTop().getnextTop());
			}
			next=next.getnextTop();
		}
	}
	
	public static void alg(list List) {
		subtask(List,'+');
		subtask(List,'*');
		subtask(List,'*');
	}
	
}
