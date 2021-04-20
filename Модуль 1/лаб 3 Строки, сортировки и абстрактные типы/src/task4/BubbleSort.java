package task4;

import java.util.Comparator;

public class BubbleSort<T> implements Sort1 {
	
	private T Array[];
	private int N;
	private int comper;
	private int swap;
	
	public BubbleSort(T Array[],int N){
		this.Array=Array;
		this.N=N;
		comper=0;
		swap=0;
	}
	
	public void bubbleSort(Comparator comparator) {
		for (int i = 0; i < N - 1; i++) {
		    for (int j = N - 1; j > i; j--){ 
		    	if (comparator.compare(Array[j - 1],Array[j])==1){
		    		swap(j-1,j);
		    		swap=swap+1;
		    	}
		    	comper=comper+1;
		    }
		}
	}
	
	public void swap(int i,int j) {
		T temp=Array[i];
		Array[i]=Array[j];
		Array[j]=temp;
	}
		    
	public int getSwap() {
		return swap;
	}
	
	public int getComp() {
		return comper;
	}
	
	public void ArrayShow() {
		System.out.print("Сортировка обменом:");
		for(int i=0;i<N;i++) {
			System.out.print(Array[i]+" ");
		}
		System.out.println();
	}
	
}
