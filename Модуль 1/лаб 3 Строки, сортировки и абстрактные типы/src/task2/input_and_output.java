package task2;

import java.util.Scanner;

public class input_and_output {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		System.out.print("������� ������:");
		String str=in.next();
		StringBuilder S=new StringBuilder(str);
		System.out.println("���������� ������:"+transform(S));
		in.close();
	}
	
	public static StringBuilder transform(StringBuilder str) {
		for(int i=0; i<str.length();i++) {
			char symbol=str.charAt(i);
			switch(symbol) {
			case '0':
				str.replace(i, i+1, "����");
				break;
			case '1':
				str.replace(i, i+1, "����");
				break;
			case '2':
				str.replace(i, i+1, "���");
				break;
			case '3':
				str.replace(i, i+1, "���");
				break;
			case '4':
				str.replace(i, i+1, "������");
				break;
			case '5':
				str.replace(i, i+1, "����");
				break;
			case '6':
				str.replace(i, i+1, "�����");
				break;
			case '7':
				str.replace(i, i+1, "����");
				break;
			case '8':
				str.replace(i, i+1, "������");
				break;
			case '9':
				str.replace(i, i+1, "������");
				break;
			}
		}
		return str;
	}
}
