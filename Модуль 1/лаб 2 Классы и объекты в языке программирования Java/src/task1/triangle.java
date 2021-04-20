package task1;

public class triangle {
	
	private double a;
	private double b;
	
	public triangle(line a) {
		this.a=a.len();
		b=this.a*Math.sqrt(2)/2;
	}
	
	public double get_a() {
		return a;
	}
	
	public double get_b() {
		return b;
	}
	
	public double get_p() {
		return (a+b+b)/2;
	}
	
	public double get_r() {
		double p=get_p();
		return p-a;
	}
	
	
}
