package task1;

public class Item {
	
	private Object element;
	private Item next;
	
	public Item(Object element) {
		this.element=element;
		next=null;
	}
	
	public void setElement(Object element) {
		this.element=element;
	}
	
	public Object getElement() {
		return element;
	}
	
	public void setNextItem(Item next) {
		this.next=next;
	}
	
	public Item getNextItem() {
		return next;
	}
	
}
