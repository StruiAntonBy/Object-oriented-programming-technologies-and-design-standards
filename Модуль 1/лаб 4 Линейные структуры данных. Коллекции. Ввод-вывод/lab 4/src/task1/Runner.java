package task1;

import java.io.IOException;
import java.util.Scanner;

public class Runner {
	
	public static int downtime1=0;
	public static int downtime2=0;
	public static int worktime1=0;
	public static int worktime2=0;
	public static int timeTmpDarn=-1;
	public static int timeTmpSew=-1;

	public static void main(String[] args) throws InterruptedException{
		Scanner in=new Scanner(System.in);
		System.out.print("Введите количество вещей:");
		int N=in.nextInt();
		System.out.print("Введите количество пуговиц:");
		int NamberButtons=in.nextInt();
		System.out.print("Введите время, которое швея затрачивает на штопку:");
		int timeDarn=in.nextInt();
		System.out.print("Введите время, за которое швея пришивает пуговицу:");
		int timeSew=in.nextInt();
		Stack inputStack=new Stack(N);
		Stack tmpStack=new Stack(N);
		Stack outputStack=new Stack(N);
		Queue queue=new Queue();
		for(int i=0;i<N;i++) {
			System.out.print("Введите время, которое затрачивается на поступление "+(i+1)+ " вещи для обработки:");
			int timeAdmission=in.nextInt();
			Item it=new Item(timeAdmission);
			queue.add(it);
		}
		in.close();
		int Alltime=1;
		while(outputStack.getSize()!=N) {
			System.out.println("Время:"+Alltime);
			if(processingQueue(queue,inputStack)) {
				System.out.println("Вещь поступила в входную стопку.");
			}
			Thread.sleep(2000);
			needlewoman1(inputStack,tmpStack,NamberButtons,timeSew);
			Thread.sleep(2000);
			needlewoman2(tmpStack,outputStack,timeDarn);
			Thread.sleep(2000);			
			Alltime++;
		}
		System.out.println("Итог");
		System.out.println("Суммарное время работы 1 швеи:"+worktime1);
		System.out.println("Суммарное время работы 2 швеи:"+worktime2);
		System.out.println("Суммарное время простоя 1 швеи:"+downtime1);
		System.out.println("Суммарное время простоя 2 швеи:"+downtime2);
	}
	
	public static boolean processingQueue(Queue queue,Stack inputStack) {
		if(queue.empty()!=true && queue.getFirstElement()==0) {
			queue.pop();
			inputStack.add("@");
			return true;
		}
		else if(queue.empty()!=true){
			queue.editFirstElement(queue.getFirstElement()-1);
			return false;
		}
		return false;
	}
	
	public static void needlewoman1(Stack inputStack,Stack tmpStack,int NamberButtons,int timeSew) {
		if(timeTmpSew==-1) {
			if(inputStack.empty()==false) {
				System.out.println("Вещь поступила к швее, которая пришивает пуговицы.");
				inputStack.pop();
				timeTmpSew=(timeSew*NamberButtons)-1;
				worktime1++;
			}
			else {
				downtime1++;
			}
		}
		else {
			if(timeTmpSew==0) {
				System.out.println("Вещь поступила в промежуточную стопку.");
				tmpStack.add("#");
				timeTmpSew=-1;
				if(inputStack.empty()==false) {
					System.out.println("Вещь поступила к швее, которая пришивает пуговицы.");
					inputStack.pop();
					timeTmpSew=(timeSew*NamberButtons)-1;
					worktime1++;
				}
				else {
					downtime1++;;
				}
			}
			else {
				timeTmpSew--;
				worktime1++;
			}
		}
	}
	
	public static void needlewoman2(Stack tmpStack,Stack outputStack,int timeDarn) {
		if(timeTmpDarn==-1) {
			if(tmpStack.empty()==false) {
				System.out.println("Вещь поступила к швее, которая штопает одежду.");
				tmpStack.pop();
				timeTmpDarn=timeDarn-1;
				worktime2++;
			}
			else {
				downtime2++;
			}
		}
		else {
			if(timeTmpDarn==0) {
				System.out.println("Вещь поступила в выходную стопку.");
				outputStack.add("$");
				timeTmpDarn=-1;
				if(tmpStack.empty()==false) {
					System.out.println("Вещь поступила к швее, которая штопает одежду.");
					tmpStack.pop();
					timeTmpDarn=timeDarn-1;
					worktime2++;
				}
				else {
					downtime2++;
				}
			}
			else {
				timeTmpDarn--;
				worktime2++;
			}
		}
	}
	
}
