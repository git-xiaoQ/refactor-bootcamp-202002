package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    public Integer calculate(int number){
        if(number==1 || number==2){
            return 1;
        }
        return calculate(number-1)+calculate(number-2);
    }
}
