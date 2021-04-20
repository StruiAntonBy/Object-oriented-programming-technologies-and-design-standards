import org.junit.Assert;
import org.junit.Test;

public class test{
	@Test
	public void test1(){
		Assert.assertEquals(91.0,task1.example9(10.0,9.0,2.0),0.0000000001);
	}
	
	@Test
	public void test2(){
		Assert.assertEquals(3.0,task1.example9(3.0,6.0,1.0),0.0000000001);
	}
}