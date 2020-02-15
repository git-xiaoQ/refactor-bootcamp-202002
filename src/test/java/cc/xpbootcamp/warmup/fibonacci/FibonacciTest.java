package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
    @Test
    public void should_return_1_when_calculate_given_number_is_1() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        Integer result = fibonacci.calculate(1);
        Integer expected = 1;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void should_return_1_when_calculate_given_number_is_2() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        Integer result = fibonacci.calculate(2);
        Integer expected = 1;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void should_return_2_when_calculate_given_number_is_3() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        Integer result = fibonacci.calculate(3);
        Integer expected = 2;
        Assert.assertEquals(expected, result);
    }

    @Test(expected = Exception.class)
    public void should_return_0_when_calculate_given_number_is_51() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        Integer result = fibonacci.calculate(51);
    }

    @Test(expected = Exception.class)
    public void should_return_0_when_calculate_given_number_is_string() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        Integer result = fibonacci.calculate('a');
    }

}