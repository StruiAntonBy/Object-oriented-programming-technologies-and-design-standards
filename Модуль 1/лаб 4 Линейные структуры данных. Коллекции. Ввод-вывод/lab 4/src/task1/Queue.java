package task1;

public class Queue {
	
	private Item start;
	private Item end;
	private int size;
	
	public Queue() {
		start=null;
		end=null;
		size=0;
	}
	
	public void add(Item unit) {
		if(start==null) {
			start=unit;
			end=start;
		}
		else {
			end.setNextItem(unit);
			end=end.getNextItem();
		}
		size++;
	}
	
	public void editFirstElement(int element) {
		start.setElement(element);
	}
	
	public int getFirstElement() {
		return (int) start.getElement();
	}
	
	public Object pop() {
		if(size!=0) {
			Object tmp=start.getElement();
			start=start.getNextItem();
			size--;
			return tmp;
		}
		return null;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean empty() {
		if(size==0) {
			return true;
		}
		return false;
	}
	
	public void print() {
		Item tmp=start;
		for(int i=0;i<size;i++) {
			System.out.print(tmp.getElement()+" ");
			tmp=tmp.getNextItem();
		}
		System.out.println();
	}
	
}
