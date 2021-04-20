package test_task1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import task1.line;

class Testline {

	@Test
	public void test_len() {
		task1.point p1=new task1.point(0,0);
		task1.point p2=new task1.point(1,0);
		task1.line l=new task1.line(p1,p2);
		double result=l.len();
		assertEquals(1,result);
	}
	
	@Test
	public void test_len1() {
		task1.point p1=new task1.point(0,0);
		task1.point p2=new task1.point(3,4);
		task1.line l=new task1.line(p1,p2);
		double result=l.len();
		assertEquals(5,result);
	}

	@Test
	public void test_get_k() {
		task1.point p1=new task1.point(2,0);
		task1.point p2=new task1.point(1,0);
		task1.line l=new task1.line(p1,p2);
		double result=l.get_k();
		assertEquals(0,result);
	}
	
	@Test
	public void test_get_k1() {
		task1.point p1=new task1.point(3,4);
		task1.point p2=new task1.point(2,2);
		task1.line l=new task1.line(p1,p2);
		double result=l.get_k();
		assertEquals(2.0,result);
	}
}
