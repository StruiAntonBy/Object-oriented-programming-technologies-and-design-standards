import org.junit.Assert;
import org.junit.Test;

public class ExpressionTestCase {
 
    @Test
    public void testDividingBiggerNumberBySmaller() {
        Assert.assertEquals(
            2.5, 
            Runner.expression(2, 5), 
            0.0000000001 
        );
    }
	
    @Test
    public void testDividingSmallerNumberByBigger() {
        Assert.assertEquals(
            0.4,
            Runner.expression(5, 2),
            0.0000000001
        );
    }

    @Test
    public void testDividingPositiveNumberByZero() {
        Assert.assertEquals(
            Double.POSITIVE_INFINITY,
            Runner.expression(0, 2),
            0.0000000001
        );
    }

    @Test
    public void testDividingNegativeNumberByZero() {
        Assert.assertEquals(
            Double.NEGATIVE_INFINITY,
            Runner.expression(0, -2),
            0.0000000001
        );
    }
}