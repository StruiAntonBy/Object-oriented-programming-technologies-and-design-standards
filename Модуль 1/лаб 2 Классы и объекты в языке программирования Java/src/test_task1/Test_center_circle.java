package test_task1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_center_circle {

	@Test
	public void test_center_circle() {
		task1.point p1=new task1.point(2,5);
		task1.point p2=new task1.point(6,1);
		task1.point result[]=task1.output_center_circle.return_center_circle(p1, p2);
		task1.point res[]=new task1.point[2];
		res[0]=new task1.point(3.171572875253811,2.171572875253811);
		assertEquals(res[0].getpoint_x(),result[0].getpoint_x());
	}
	
	@Test
	public void test_center_circle1() {
		task1.point p1=new task1.point(2,5);
		task1.point p2=new task1.point(6,1);
		task1.point result[]=task1.output_center_circle.return_center_circle(p1, p2);
		task1.point res[]=new task1.point[2];
		res[0]=new task1.point(3.171572875253811,2.171572875253811);
		res[1]=new task1.point(4.828427124746189,3.828427124746189);
		assertEquals(res[1].getpoint_x(),result[1].getpoint_x());
	}
}
