package test_task1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testtriangle {

	@Test
	public void test_get_r() {
		task1.point p1=new task1.point(0,0);
		task1.point p2=new task1.point(0,0);
		task1.line l=new task1.line(p1,p2);
		task1.triangle t=new task1.triangle(l);
		double result=t.get_r();
		assertEquals(0,result);
	}
	
	@Test
	public void test_get_r1() {
		task1.point p1=new task1.point(0,2);
		task1.point p2=new task1.point(2,0);
		task1.line l=new task1.line(p1,p2);
		task1.triangle t=new task1.triangle(l);
		double result=t.get_r();
		assertEquals(0.586,result,0.01);
	}
    
	@Test
	public void test_get_p() {
		task1.point p1=new task1.point(0,0);
		task1.point p2=new task1.point(0,0);
		task1.line l=new task1.line(p1,p2);
		task1.triangle t=new task1.triangle(l);
		double result=t.get_p();
		assertEquals(0,result);
	}
	
	@Test
	public void test_get_p1() {
		task1.point p1=new task1.point(0,2);
		task1.point p2=new task1.point(2,0);
		task1.line l=new task1.line(p1,p2);
		task1.triangle t=new task1.triangle(l);
		double result=t.get_p();
		assertEquals(3.4142,result,0.01);
	}
	
}
