package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class FibonacciTest {
    @Test
    public void should_return_1_when_calculate_given_number_is_1(){
        Fibonacci fibonacci = new Fibonacci();
        ArrayList<Integer> result = fibonacci.calculate(1);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        Assert.assertEquals(expected,result);
    }

}