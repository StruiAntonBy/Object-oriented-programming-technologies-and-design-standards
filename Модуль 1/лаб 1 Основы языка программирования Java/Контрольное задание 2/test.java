import org.junit.Assert;
import org.junit.Test;

public class test{
	@Test
	public void test1(){
		int n=example9.return_n(Float.parseFloat("0.0001"),1);
		Assert.assertEquals(Math.sin(1),example9.sin(n,1),0.0001);
	}
	@Test
	public void test2(){
		int n=example9.return_n(Float.parseFloat("0.0001"),2);
		Assert.assertEquals(Math.sin(2),example9.sin(n,2),0.0001);
	}
	@Test
	public void test3(){
		int n=example9.return_n(Float.parseFloat("0.0001"),-2);
		Assert.assertEquals(Math.sin(-2),example9.sin(n,-2),0.0001);
	}
	@Test
	public void test4(){
		int n=example9.return_n(Float.parseFloat("0.0001"),-1);
		Assert.assertEquals(Math.sin(-1),example9.sin(n,-1),0.0001);
	}
}