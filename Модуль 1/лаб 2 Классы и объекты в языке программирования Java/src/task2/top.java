package task2;

public class top {

	private int Elem;
	private char nextOperation;
	private top nextTop;
	private top prevTop;
	
	public top(int Elem,char nextOperation) {
		this.Elem=Elem;
		this.nextOperation=nextOperation;
		this.nextTop=null;
		this.prevTop=null;
	}
	
	public top(int Elem) {
		this.Elem=Elem;
		nextOperation='|';
		this.nextTop=null;
		this.prevTop=null;
	}
	
	public int getElem() {
		return Elem;
	}
	
	public void setElem(int Elem) {
		this.Elem=Elem;
	}
	
	public top getnextTop() {
		return nextTop;
	}
	
	public void setnextTop(top nextTop) {
		this.nextTop=nextTop;
	}
	
	public top getprevTop() {
		return prevTop;
	}
	
	public void setprevTop(top prevTop) {
		this.prevTop=prevTop;
	}
	
	public char getnextOperation() {
		return nextOperation;
	}
	
	public void setnextOperation(char nextOperation) {
		this.nextOperation=nextOperation;
	}
	
}
