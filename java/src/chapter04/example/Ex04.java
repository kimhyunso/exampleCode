package chapter04.example;

public class Ex04 {
    public static void main(String[] args) {
        boolean flag = true;
        while(flag){
            int dice1=(int)(Math.random()*6+1);
            int dice2=(int)(Math.random()*6+1);
            if(dice1 + dice2 == 5)
                flag = false;
            else
                flag = true;
            System.out.println("("+dice1+", "+dice2+")");
        }
    }
}
