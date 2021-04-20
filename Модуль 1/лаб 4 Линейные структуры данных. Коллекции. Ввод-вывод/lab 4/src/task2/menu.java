package task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menu {

	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.print("Введите имя файла:");
		String FileName=in.next();
		List<InfBookIssuance> data=new ArrayList<>();
		data=inputData(FileName);
		cls();
		for(;;) {
			System.out.println("1.Просмотр данных.");
			System.out.println("2.Добавить новые данные.");
			System.out.println("3.Редактировать данные.");
			System.out.println("4.Удалить данные.");
			System.out.println("5.Cписок находившихся книг у читателя на выбранную дату.");
			System.out.println("6.Список всех читателей, взявших выбранную книгу.");
			System.out.println("7.Выход.");
			int next=in.nextInt();
			switch(next) {
			case 1:
				cls();
				beautifulprint(data);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cls();
				break;
			case 2:
				cls();
				System.out.print("Введите количество данных, которые хотите добавить:");
				int N=in.nextInt();
				cls();
				for(int i=0;i<N;i++) {
					System.out.println((i+1));
					System.out.print("Фамилия читателя:");
					String LastName=in.next();
					System.out.print("Инициалы читателя:");
					String Initials=in.next();
					String LastNameReaderAndInitials=LastName+" "+Initials;
					System.out.print("Название книги:");
					String BookName=in.next();
					System.out.print("Автор:");
					String BookAuthor=in.next();
					System.out.print("Дата выдачи книги:");
					String DateIssueBook=in.next();
					System.out.print("Дата возврата книги:");
					String DateReturnedBook=in.next();
					data.add(new InfBookIssuance(LastNameReaderAndInitials,BookName,BookAuthor,DateIssueBook,DateReturnedBook));
					cls();
				}
				outputData(data,FileName);
				data=inputData(FileName);
				break;
			case 3:
				cls();
				System.out.print("Введите количество данных, которые хотите редактировать:");
				int m=in.nextInt();
				for(int i=0;i<m;i++) {
					beautifulprint(data);
					System.out.println("Введите номер данных, который хотите редактировать:");
					int index=in.nextInt();
					System.out.print("Фамилия читателя:");
					String LastName=in.next();
					System.out.print("Инициалы читателя:");
					String Initials=in.next();
					String LastNameReaderAndInitials=LastName+" "+Initials;
					data.get(index-1).setLastNameReaderAndInitials(LastNameReaderAndInitials);
					System.out.print("Название книги:");
					data.get(index-1).setBookName(in.next());
					System.out.print("Автор:");
					data.get(index-1).setBookAuthor(in.next());
					System.out.print("Дата выдачи книги:");
					data.get(index-1).setDateIssueBook(in.next());
					System.out.print("Дата возврата книги:");
					data.get(index-1).setDateReturnedBook(in.next());
					cls();
				}
				outputData(data,FileName);
				data=inputData(FileName);
				break;
			case 4:
				cls();
				System.out.print("Введите количество данных, которые хотите удалить:");
				int n=in.nextInt();
				for(int i=0;i<n;i++) {
					beautifulprint(data);
					System.out.print("Введите номер данных, который хотите удалить:");
					int ind=in.nextInt();
					data.remove(ind-1);
					cls();
				}
				outputData(data,FileName);
				data=inputData(FileName);
				break;
			case 5:
				cls();
				System.out.print("Фамилия читателя:");
				String LastName=in.next();
				System.out.print("Инициалы читателя:");
				String Initials=in.next();
				String LastNameReaderAndInitials=LastName+" "+Initials;
				System.out.print("Дата:");
				String Date=in.next();
				int arrayDate[]=parseIntArray(splitDate(Date));
				List<InfBookIssuance> mas=new ArrayList<>();
				for(int i=0;i<data.size();i++) {
					InfBookIssuance inf=data.get(i);
					if(LastNameReaderAndInitials.equals(inf.getLastNameReaderAndInitials())) {
						int arrayDateInfIssue[]=parseIntArray(splitDate(inf.getDateIssueBook()));
						int arrayDateInfReturned[]=parseIntArray(splitDate(inf.getDateReturnedBook()));
						int res= ComparisonDate(arrayDateInfIssue[2],arrayDate[2],arrayDateInfReturned[2]);
						if(res==1) {
							mas.add(inf);
						}
						else if(res==0) {
							res=ComparisonDate(arrayDateInfIssue[1],arrayDate[1],arrayDateInfReturned[1]);
							if(res==1) {
								mas.add(inf);
							}
							else if(res==0) {
								res=ComparisonDate(arrayDateInfIssue[0],arrayDate[0],arrayDateInfReturned[0]);
								if(res==1 || res==0) {
									mas.add(inf);
								}
							}
						}
					}
				}
				System.out.println(LastNameReaderAndInitials);
				for(int i=0;i<mas.size();i++) {
					System.out.println((i+1)+"."+mas.get(i).getBookName());
				}
				mas.clear();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cls();
				break;
			case 6:
				cls();
				System.out.print("Название книги:");
				String BookName=in.next();
				System.out.print("Автор:");
				String BookAuthor=in.next();
				List<InfBookIssuance> mat=new ArrayList<>();
				for(int i=0;i<data.size();i++) {
					InfBookIssuance inf=data.get(i);
					if(BookAuthor.equals(inf.getBookAuthor()) && BookName.equals(inf.getBookName())) {
						mat.add(inf);
					}
				}
				System.out.println("Список всех читателей.");
				for(int i=0;i<mat.size();i++) {
					System.out.println((i+1)+"."+mat.get(i).getLastNameReaderAndInitials());
				}
				mat.clear();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cls();
				break;
			case 7:
				cls();
				in.close();
				return;
			}
		}
	}
	
	public static String[] splitDate(String data) {
		String array[]=new String[3];
		int i1=data.indexOf('.');
		int i2=data.lastIndexOf('.');
		array[2]=data.substring(i2+1);
		array[1]=data.substring(i1+1,i2);
		array[0]=data.substring(0,i1);
		return array;
	}
	
	public static int ComparisonDate(int startdate,int date,int enddate) {
		if(startdate<date && enddate>date) {
			return 1;
		}
		else if(startdate==date || enddate==date) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public static int[] parseIntArray(String Array[]) {
		int arr[]=new int[Array.length];
		for(int i=0;i<Array.length;i++) {
			arr[i]=Integer.parseInt(Array[i]);
		}
		return arr;
	}
	
	public static void beautifulprint(List<InfBookIssuance> data) {
		for(int i=0;i<data.size();i++) {
			System.out.println((i+1)+"."+data.get(i).toString());
		}
	}
	
	public static void cls() {
		for(int i=0;i<10;i++) {
			System.out.println();
		}
	}
	
	public static void outputData(List<InfBookIssuance> data,String FileName) {
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(FileName));
			for(int i=0;i<data.size();i++) {
				writer.write(data.get(i).toString());
				writer.newLine();
			}
			data.clear();
			writer.close();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<InfBookIssuance> inputData(String FileName) {
		List<InfBookIssuance> data=new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FileName));
			int index=0;
			String line=null;
			Scanner scanner=null;
			try {
				while((line=reader.readLine())!=null) {
					InfBookIssuance inf=new InfBookIssuance();
					scanner=new Scanner(line);
					scanner.useDelimiter(";");
					while(scanner.hasNext()) {
						String str=scanner.next();
						switch(index) {
						case 0:
							inf.setLastNameReaderAndInitials(str);
							break;
						case 1:
							inf.setBookName(str);
							break;
						case 2:
							inf.setBookAuthor(str);
							break;
						case 3:
							inf.setDateIssueBook(str);
							break;
						case 4:
							inf.setDateReturnedBook(str);
							break;
						}
						index++;
					}
					index=0;
					data.add(inf);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
		}
		return data;
	}

}
