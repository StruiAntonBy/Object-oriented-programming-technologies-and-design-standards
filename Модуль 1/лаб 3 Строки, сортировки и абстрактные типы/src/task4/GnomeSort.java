package task4;

import java.util.Comparator;

public class GnomeSort<T> implements Sort2{
	
	private T Array[];
	private int N;
	private int comper;
	private int swap;
	
	public GnomeSort(T Array[],int N){
		this.Array=Array;
		this.N=N;
		comper=0;
		swap=0;
	}
	
	public void gnomeSort(Comparator comparator) {
		int i=1;
		int j=2;
		while (i<N){
			if (comparator.compare(Array[i-1],Array[i])==-1){
				comper=comper+1;
				i=j; 
				j++; 
			}
			else{
				comper=comper+1;
				swap(i,i-1);
				swap=swap+1;
				i--;
				if (i==0){ 
					i=j;
					j++; 
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
		System.out.print("Гномья сортировка:");
		for(int i=0;i<N;i++) {
			System.out.print(Array[i]+" ");
		}
		System.out.println();
	}
}
