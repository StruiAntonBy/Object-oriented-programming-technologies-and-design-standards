package task1;

public class point {

	private double x;
	private double y;
	
	public point(double x,double y) {
		this.x=x;
		this.y=y;
	}
	
	public double getpoint_x() {
		return x;
	}
	
	public double getpoint_y() {
		return y;
	}
	
	public double [] getpoint() {
		double arg[]=new double[2];
		arg[0]=x;
		arg[1]=y;
		return arg;
	}
}
