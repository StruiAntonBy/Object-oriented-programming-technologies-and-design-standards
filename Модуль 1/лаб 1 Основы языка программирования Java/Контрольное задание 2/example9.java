public class example9{
	
	public static int factorial(int n){
		if (n<1) return 1;
		return n*factorial(n-1);
	}
	
	public static double sin(int n,double x){
		double ressult=0.0;
		for(int i=0;i<n;i++){
			ressult+=(Math.pow(-1,i)*Math.pow(x,2*i+1))/factorial(2*i+1);
		}
		return ressult;
	}
	
	public static int return_n(float e,double x){
		int i=0;
		while(Math.abs(Math.pow(x,2*i+1)/factorial(2*i+1))>e){
			i+=1;
		}
		return i;
	}
	
	public static void main(String args[]){
		double x=Double.parseDouble(args[0]);
		float e=Float.parseFloat(args[1]);
		int n=return_n(e,x);
		System.out.println("return:"+sin(n,x));
		System.out.print("return Math:"+Math.sin(x));
	}
	
}