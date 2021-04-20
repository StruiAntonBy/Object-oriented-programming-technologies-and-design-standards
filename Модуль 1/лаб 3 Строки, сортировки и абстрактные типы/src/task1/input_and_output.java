package task1;

import java.util.Scanner;
import java.util.Arrays;

public class input_and_output {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		System.out.print("Введите подстроку:");
		String substring=in.next();
		showArray(args);
		StringBuilder b[]=converting(args);
		args=sort1(b,substring);
		showArray(args);
		System.out.print("Введите подстроку1:");
		String substring1=in.next();
		System.out.print("Введите подстроку2:");
		String substring2=in.next();
		in.close();
		args=sort2(args,substring1,substring2);
		showArray(args);
	}
	
	public static void showArray(String[] arrayStr) {
		System.out.println("Массив строк:");
		int n=arrayStr.length;
		for(int i=0;i<n;i++) {
			System.out.println(arrayStr[i]);
		}
	}
	
	public static String[] sort2(String[] arrayStr,String substring1,String substring2) {
		StringCompatator comporator=new StringCompatator(substring1,substring2);
		Arrays.sort(arrayStr, comporator);
		System.out.println("Количество операций сравнения:"+comporator.getComp());
		return arrayStr;
	}
	
	public static StringBuilder[] converting(String[] arrayStr) {
		int n=arrayStr.length;
		StringBuilder mas[]=new StringBuilder[n];
		for(int i=0;i<n;i++) {
			mas[i]=new StringBuilder(arrayStr[i]);
		}
		return mas;
	}
	
	public static String[] convertingString(StringBuilder[] arrayStr) {
		int n=arrayStr.length;
		String mas[]=new String[n];
		for(int i=0;i<n;i++) {
			mas[i]=new String(arrayStr[i].toString());
		}
		return mas;
	}
	
	public static String[] sort1(StringBuilder argv[],String substring) {
		int comp=0;
		int n=argv.length;
		for(int i=0;i<n;i++) {
			int pos=argv[i].lastIndexOf(substring);
			StringBuilder tmp=argv[i];
			for(int j=i-1;j>=0;j--) {
				if(pos<argv[j].lastIndexOf(substring)) {
					comp=comp+1;
					StringBuilder buf=argv[j];
					argv[j]=tmp;
					argv[j+1]=buf;
				}
				else {
					comp=comp+1;
					break;
				}
			}
		}
		System.out.println("Количество операций сравнения:"+comp);
		String array[]=convertingString(argv);
		return array;
	}
}
	
