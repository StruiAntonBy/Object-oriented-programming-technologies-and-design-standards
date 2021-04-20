package task4_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import task4.*;
import org.junit.Assert;

class SortOption10Test {

	@Test
	void test1() {
		Integer array[]= new Integer[]{9,8,7,6,5,4,3,2,1,0};
		Integer res[]=new Integer[] {0,1,2,3,4,5,6,7,8,9};
		BubbleSort<Integer> ob=new BubbleSort(array,10);
		IntegerComparator comp=new IntegerComparator();
		ob.bubbleSort(comp);
		Assert.assertArrayEquals(res,array);
	}
	
	@Test
	void test2() {
		Integer array[]= new Integer[]{9,8,7,6,5,4,3,2,1,0};
		Integer res[]=new Integer[] {0,1,2,3,4,5,6,7,8,9};
		GnomeSort<Integer> ob=new GnomeSort(array,10);
		IntegerComparator comp=new IntegerComparator();
		ob.gnomeSort(comp);
		Assert.assertArrayEquals(res,array);
	}

}
