package cc.xpbootcamp.warmup.fibonacci;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class Fibonacci {
    public Integer calculate(int number) throws Exception{
        if(number>50 || number<1){
            throw new Exception("number is out of range");
        }
        if(number==1 || number==2){
            return 1;
        }
        return calculate(number-1)+calculate(number-2);
    }
}
