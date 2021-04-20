package task4;

import java.util.Comparator;

public class Runner {

	public static void main(String[] args) {
		IntegerComparator comp=new IntegerComparator();
		Stringcomparator comp1=new Stringcomparator();
		BubbleSortOutput(comp,comp1);
		GnomeSortOutput(comp,comp1);
	}
	
	public static void GnomeSortOutput(Comparator comp,Comparator comp1) {
		Integer array[]=new Integer[] {1,0,-1,2,4,-8,5,6,7,-10};
		String Array[]=new String[] {"1","1234567890","23","234","133982183191328893189","3213"};
		GnomeSort<Integer> ob1=new GnomeSort(array,array.length);
		GnomeSort<String> ob2=new GnomeSort(Array,Array.length);
		Sort2 inter1=ob1;
		inter1.gnomeSort(comp);
		output(inter1);
		inter1=ob2;
		inter1.gnomeSort(comp1);
		output(inter1);
	}
	
	public static void BubbleSortOutput(Comparator comp,Comparator comp1) {
		Integer array[]=new Integer[] {1,0,-1,2,4,-8,5,6,7,-10};
		String Array[]=new String[] {"1","1234567890","23","234","133982183191328893189","3213"};
		BubbleSort<Integer> ob1=new BubbleSort(array,array.length);
		BubbleSort<String> ob2=new BubbleSort(Array,Array.length);
		Sort1 inter1=ob1;
		inter1.bubbleSort(comp);
		output(inter1);
		inter1=ob2;
		inter1.bubbleSort(comp1);
		output(inter1);
	}
	
	public static void output(SortOption10 inter) {
		inter.ArrayShow();
		System.out.println("Число операций обмена:"+inter.getSwap());
		System.out.println("Число операций сравнения:"+inter.getComp());
	}

}
