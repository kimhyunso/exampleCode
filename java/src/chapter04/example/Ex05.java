package chapter04.example;

public class Ex05 {
    public static void main(String[] args) {
        int xC = 4;
        int yC = 5;

        for(int x=1; x<=10; x++){
            for(int y=1; y<=10; y++){
                if(xC*x + yC*y == 60){
                    System.out.println("("+x+", "+y+")");
                }
            }

        }


    }

}
