package task2_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MenuTest {

	@Test
	void test1() {
		task2.InfBookIssuance inf=new task2.InfBookIssuance("a","b","c","d","e");
		Assert.assertEquals("a;b;c;d;e",inf.toString());
	}
	
	@Test
	void test2() {
		String res[]={"20","03","2020"};
		Assert.assertArrayEquals(res, task2.menu.splitDate("20.03.2020"));
	}
	
	@Test
	void test3() {
		int res[]={20,3,2020};
		Assert.assertArrayEquals(res,task2.menu.parseIntArray(task2.menu.splitDate("20.03.2020")));
	}
	
	@Test
	void test4() {
		Assert.assertEquals(1,task2.menu.ComparisonDate(2020, 2021, 2022));
	}
	
}
