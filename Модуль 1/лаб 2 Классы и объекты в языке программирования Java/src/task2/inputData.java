package task2;

import java.util.Scanner;

public class inputData {

	public static list input() {
		Scanner in= new Scanner(System.in);
		System.out.print("������� ���������� ������:");
		int n=in.nextInt();
		if (n>50 | n<3) {
			System.out.println("������");
			in.close();
			return null;
		}
		else {
			list l=new list();
			top Top;
			System.out.print("������� ����� ��� ������� "+0+":");
			int Namber=in.nextInt();
			System.out.print("������� �������� ����� "+0+" � "+1+":");
			char NextOperation=in.next().charAt(0);
			Top=new top(Namber,NextOperation);
			l.setStart(Top);
			for(int i=1;i<n-1;i++) {
				System.out.print("������� ����� ��� ������� "+i+":");
				Namber=in.nextInt();
				System.out.print("������� �������� ����� "+i+" � "+(i+1)+":");
				NextOperation=in.next().charAt(0);
				Top=new top(Namber,NextOperation);
				l.addList(Top);
			}
			System.out.print("������� ����� ��� ������� "+n+":");
			Namber=in.nextInt();
			Top=new top(Namber);
			l.addList(Top);
			in.close();
			return l;
		}
	}
}
