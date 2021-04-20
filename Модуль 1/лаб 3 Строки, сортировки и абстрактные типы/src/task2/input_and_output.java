package task2;

import java.util.Scanner;

public class input_and_output {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		System.out.print("Введите строку:");
		String str=in.next();
		StringBuilder S=new StringBuilder(str);
		System.out.println("Измененная строка:"+transform(S));
		in.close();
	}
	
	public static StringBuilder transform(StringBuilder str) {
		for(int i=0; i<str.length();i++) {
			char symbol=str.charAt(i);
			switch(symbol) {
			case '0':
				str.replace(i, i+1, "ноль");
				break;
			case '1':
				str.replace(i, i+1, "один");
				break;
			case '2':
				str.replace(i, i+1, "два");
				break;
			case '3':
				str.replace(i, i+1, "три");
				break;
			case '4':
				str.replace(i, i+1, "четыре");
				break;
			case '5':
				str.replace(i, i+1, "пять");
				break;
			case '6':
				str.replace(i, i+1, "шесть");
				break;
			case '7':
				str.replace(i, i+1, "семь");
				break;
			case '8':
				str.replace(i, i+1, "восемь");
				break;
			case '9':
				str.replace(i, i+1, "девять");
				break;
			}
		}
		return str;
	}
}
