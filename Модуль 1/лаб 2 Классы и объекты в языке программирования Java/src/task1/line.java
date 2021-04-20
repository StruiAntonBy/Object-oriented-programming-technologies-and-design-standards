package task1;

public class line {
	
	private point p1;
	private point p2;
	
	public line(point p1,point p2) {
		this.p1=p1;
		this.p2=p2;
	}
	
	public double len() {
		return Math.sqrt(Math.pow((p1.getpoint_x()-p2.getpoint_x()),2)+Math.pow((p1.getpoint_y()-p2.getpoint_y()),2));
	}

	public double get_k() {
		return (p1.getpoint_y()-p2.getpoint_y())/(p1.getpoint_x()-p2.getpoint_x());
	}
	
}
