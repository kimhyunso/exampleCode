package chapter11.example;

import java.util.StringTokenizer;

public class SplitEx {
    public static void main(String[] args) {
        String str = "아이디,이름,패스워드";

        //방법 1
        String[] strs = str.split(",");
        for(String s : strs)
            System.out.println(s);

        System.out.println();


        //방법 2
        StringTokenizer st = new StringTokenizer(str,",");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }


    }
}
