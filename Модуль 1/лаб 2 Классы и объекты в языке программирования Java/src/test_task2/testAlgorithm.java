package test_task2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testAlgorithm {

	@Test
	public void test_alg() {
		task2.list List=task2.inputData.input();
		task2.algorithm.alg(List);
		int result=List.getStart().getElem();
		assertEquals(105,result);//1+2*3+4*5
	}
	
}
