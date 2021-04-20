package task1;

public class Stack {
	
	private Object Array[];
	private int maxSize;
	private int cursor;
	
	public Stack(int maxSize){
		this.maxSize=maxSize;
		Array=new Object[maxSize];
		cursor=-1;
	}
	
	public void add(Object element) {
		cursor=cursor+1;
		Array[cursor]=element;
	}
	
	public int getSize() {
		return cursor+1;
	}
	
	public void AllShow() {
		for(int i=cursor;i>=0;i--) {
			System.out.print(Array[i]+" ");
		}
		System.out.println();
	}
	
	public Object pop() {
		if(empty()!=true) {
			Object tmp=Array[cursor];
			cursor=cursor-1;
			return tmp;
		}
		return null;
	}
	
	public boolean empty() {
		if(cursor==-1) {
			return true;
		}
		return false;
	}
}
