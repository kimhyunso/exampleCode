package chapter04.example;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        boolean run = true;
        int balance = 0;
        Scanner sc = new Scanner(System.in);

        int choose = 0;
        int temp = 0;
        while(run){
            System.out.println("--------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("--------------------");
            System.out.print("선택> ");
            choose = sc.nextInt();

            if(choose < 1 || choose > 4)
                return;

            switch(choose){
                case 1:
                    System.out.print("예금액>");
                    temp = sc.nextInt();
                    if(temp < 1) {
                        System.out.println("예금실패");
                        continue;
                    }
                    balance += temp;
                    break;
                case 2:
                    System.out.print("출금액>");
                    temp = sc.nextInt();
                    if(temp < 1 || (balance-temp) < 0) {
                        System.out.println("출금실패");
                        continue;
                    }
                    balance -= temp;
                    break;
                case 3:
                    System.out.println("잔고> "+balance);
                    break;
                default:
                    run = false;
                    return;
            }
        }
    }

}
