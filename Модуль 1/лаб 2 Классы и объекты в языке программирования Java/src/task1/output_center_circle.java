package task1;

public class output_center_circle {
	
	public static point[] return_center_circle(point p1,point p2) {
		line a=new line(p1,p2);
		point arg[]=new point [2];
		double k=a.get_k();
		triangle tr=new triangle(a);
		double r=tr.get_r();
		double hypot=tr.get_a();
		double x1=0,y1=0,x2=0,y2=0;
		if(p1.getpoint_x()==p2.getpoint_x()) {
			if(p1.getpoint_y()>p2.getpoint_y()) {
				x1=p1.getpoint_x()-r;
				x2=p1.getpoint_x()+r;
				y1=y2=p1.getpoint_y()-(hypot/2);
			}
			else {
				x1=p1.getpoint_x()-r;
				x2=p1.getpoint_x()+r;
				y1=y2=p2.getpoint_y()-(hypot/2);
			}
		}
		else if(p1.getpoint_y()==p2.getpoint_y()) {
			if(p1.getpoint_x()>p2.getpoint_x()) {
				x1=x2=p1.getpoint_x()-(hypot/2);
				y1=p1.getpoint_y()+r;
				y2=p1.getpoint_y()-r;
			}
			else {
				x1=x2=p2.getpoint_x()-(hypot/2);
				y1=p1.getpoint_y()+r;
				y2=p1.getpoint_y()-r;
			}
		}
		else if(k<0) {
			if (p1.getpoint_y()>p2.getpoint_y()) {
				x1=p1.getpoint_x()+r;
				y1=p2.getpoint_y()+r;
				x2=p2.getpoint_x()-r;
				y2=p1.getpoint_y()-r;
			}
			else {
				x1=p2.getpoint_x()+r;
				y1=p1.getpoint_y()+r;
				x2=p1.getpoint_x()-r;
				y2=p2.getpoint_y()-r;
			}
		}
		else if(k>0) {
			if (p1.getpoint_y()>p2.getpoint_y()) {
				x1=p1.getpoint_x()-r;
				y1=p2.getpoint_y()+r;
				x2=p2.getpoint_x()+r;
				y2=p1.getpoint_y()-r;
			}
			else {
				x1=p2.getpoint_x()-r;
				y1=p1.getpoint_y()+r;
				x2=p1.getpoint_x()+r;
				y2=p2.getpoint_y()-r;
			}
		}
		point c1=new point(x1,y1);
		point c2=new point(x2,y2);
		arg[0]=c1;
		arg[1]=c2;
		return arg;
	}
}
