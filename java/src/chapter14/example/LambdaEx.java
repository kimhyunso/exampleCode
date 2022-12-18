package chapter14.example;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class LambdaEx {
    private static int[] scores = {10,50,3};

    public static int maxOrMin(IntBinaryOperator operator){
        int result = scores[0];
        for(int score : scores)
            result = operator.applyAsInt(result,score);
        return result;
    }

    public static void main(String[] args) {
        //int max = maxOrMin(Math::max);
        int max = maxOrMin((x,y)->{
            if(x > y) return x;
            else return y;
        });
        System.out.println("최대값: "+max);

        //int min = maxOrMin(Math::min);
        int min = maxOrMin((x,y)->{
            if (x < y) return x;
            else return y;
        });
        System.out.println("최소값: "+min);
    }
}