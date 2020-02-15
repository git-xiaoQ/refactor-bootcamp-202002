package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
    @Test
    public void should_return_1_when_calculate_given_number_is_1(){
        Fibonacci fibonacci = new Fibonacci();
        Integer result = fibonacci.calculate(1);
        Integer expected = 1;
        Assert.assertEquals(expected,result);
    }
    @Test
    public void should_return_1_when_calculate_given_number_is_2(){
        Fibonacci fibonacci = new Fibonacci();
        Integer result = fibonacci.calculate(2);
        Integer expected = 1;
        Assert.assertEquals(expected,result);
    }
    @Test
    public void should_return_2_when_calculate_given_number_is_3(){
        Fibonacci fibonacci = new Fibonacci();
        Integer result = fibonacci.calculate(3);
        Integer expected = 2;
        Assert.assertEquals(expected,result);
    }

}