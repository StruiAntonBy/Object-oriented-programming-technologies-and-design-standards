package task2;

import java.util.Scanner;

public class inputData {

	public static list input() {
		Scanner in= new Scanner(System.in);
		System.out.print("¬ведите количество вершин:");
		int n=in.nextInt();
		if (n>50 | n<3) {
			System.out.println("ќшибка");
			in.close();
			return null;
		}
		else {
			list l=new list();
			top Top;
			System.out.print("¬ведите число дл€ вершины "+0+":");
			int Namber=in.nextInt();
			System.out.print("¬ведите операцию между "+0+" и "+1+":");
			char NextOperation=in.next().charAt(0);
			Top=new top(Namber,NextOperation);
			l.setStart(Top);
			for(int i=1;i<n-1;i++) {
				System.out.print("¬ведите число дл€ вершины "+i+":");
				Namber=in.nextInt();
				System.out.print("¬ведите операцию между "+i+" и "+(i+1)+":");
				NextOperation=in.next().charAt(0);
				Top=new top(Namber,NextOperation);
				l.addList(Top);
			}
			System.out.print("¬ведите число дл€ вершины "+n+":");
			Namber=in.nextInt();
			Top=new top(Namber);
			l.addList(Top);
			in.close();
			return l;
		}
	}
}
