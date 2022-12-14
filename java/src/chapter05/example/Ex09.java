package chapter05.example;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        boolean run = true;
        int studentNum = 0;
        int[] scores = null;
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        double avg = 0.0;
        int max = 0;

        while(run){
            System.out.println("----------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("----------------------------------------------------");
            System.out.print("선택> ");

            int selectNo = sc.nextInt();

            if(selectNo == 1){
                System.out.print("학생수> ");
                studentNum = sc.nextInt();
                scores = new int[studentNum];
            }else if(selectNo == 2){
                if(studentNum == 0){
                    System.out.println("학생수 필수입력!");
                    continue;
                }
                for(int i=0; i<scores.length; i++){
                    System.out.print("scores["+i+"]> ");
                    scores[i] = sc.nextInt();
                }

            }else if(selectNo == 3){
                if(studentNum == 0){
                    System.out.println("학생수 필수입력!");
                    continue;
                }
                for(int i=0; i<scores.length; i++){
                    System.out.println("scores["+i+"]: "+scores[i]);
                }
            }else if(selectNo == 4){
                if(studentNum == 0){
                    System.out.println("학생수 필수입력!");
                    continue;
                }
                for(int i=0; i<scores.length; i++){
                    /*if(!((i+1) >= studentNum) && scores[i] > scores[i+1])
                        max = scores[i];*/
                    if(scores[i] > max)
                        max = scores[i];

                    sum += scores[i];
                }
                avg = (double)sum/studentNum;
                System.out.println("최고 점수: "+max);
                System.out.println("평균 점수: "+avg);
            }else if(selectNo == 5){
                run = false;
                return;
            }
        }
    }
}
