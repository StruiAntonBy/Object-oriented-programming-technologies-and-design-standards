package task2;

public class list {
	
	private top start;
	private top end;
	
	public list() {
		start=null;
		end=null;
	}
	
	public void setStart(top start) {
		end=start;
		this.start=end;
	}
	
	public top getStart() {
		return start;
	}
	
	public void addList(top nextTop) {
		end.setnextTop(nextTop);
		top prevTop=end;
		end=end.getnextTop();
		end.setprevTop(prevTop);
	}
	
	public void allShow() {
		top next=start;
		while(next!=null) {
			System.out.print(next.getElem()+" "+next.getnextOperation()+" ");
			next=next.getnextTop();
		}
		System.out.print("\n");
	}
	
}
