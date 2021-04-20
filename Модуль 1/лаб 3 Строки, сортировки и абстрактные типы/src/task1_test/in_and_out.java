package task1_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import task1.input_and_output;
import org.junit.Assert;

class in_and_out {

	@Test
	void test1() {
		String res[]= {"++abcd--","++bcda--","++cfdsf--"};
		String arg[]={"++cfdsf--","++bcda--","++abcd--"};
		String ret[]=task1.input_and_output.sort2(arg, "++", "--");
		Assert.assertArrayEquals(res,ret);
	}
	
	@Test
	void test2() {
		String res[]= {"xyzall","dxyzf","abxyz"};
		String arg[]={"dxyzf","xyzall","abxyz"};
		StringBuilder b[]=task1.input_and_output.converting(arg);
		String ret[]=task1.input_and_output.sort1(b, "xyz");
		Assert.assertArrayEquals(res,ret);
	}

}
