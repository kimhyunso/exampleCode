package chapter06;

public class Computer {

    public Computer(){

    }

    public int sum1(int[] values){
        int sum = 0;
        for(int value : values)
            sum += value;
        return sum;
    }

    public int sum2(int ... values){
        int sum = 0;
        for(int value : values)
            sum += value;

        return sum;
    }

}
