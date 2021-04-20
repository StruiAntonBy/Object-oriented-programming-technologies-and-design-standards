public class task1{
	public static double example9(double a,double b,double c){
		return Math.pow(a,2)-(Math.pow(b,2)/(Math.pow(c,2)+5));
	}
	public static void main(String args[]){
		double a=Double.parseDouble(args[0]);
		double b=Double.parseDouble(args[1]);
		double c=Double.parseDouble(args[2]);
		System.out.println("return:"+example9(a,b,c));
	}
}