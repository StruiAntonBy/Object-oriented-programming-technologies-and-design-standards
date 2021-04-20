package task1;

import java.util.Scanner;

public class input_and_output {

	public static void main(String[] args) {
		double x1,x2,y1,y2;
		point arg[]=new point [2];
		Scanner in= new Scanner(System.in);
		System.out.print("¬ведите x1:");
		x1=in.nextDouble();
		System.out.print("¬ведите y1:");
		y1=in.nextDouble();
		System.out.print("¬ведите x2:");
		x2=in.nextDouble();
		System.out.print("¬ведите y2:");
		y2=in.nextDouble();
		in.close();
		point p1=new point(x1,y1);
		point p2=new point(x2,y2);
		arg=output_center_circle.return_center_circle(p1,p2);
		System.out.println("÷ентры окружностей:");
		System.out.println("(x1="+arg[0].getpoint_x()+","+"y1="+arg[0].getpoint_y()+")");
		System.out.println("(x2="+arg[1].getpoint_x()+","+"y2="+arg[1].getpoint_y()+")");
	}

}
