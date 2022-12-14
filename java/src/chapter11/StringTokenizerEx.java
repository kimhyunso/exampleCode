package chapter11;

import java.util.StringTokenizer;

public class StringTokenizerEx {
    public static void main(String[] args) {
        String text = "홍길동/이수홍/박연수";
        String delimiter = "/";

        StringTokenizer str = new StringTokenizer(text,delimiter);
        int countTokens = str.countTokens();
        for(int i=0; i<countTokens; i++){
            String token = str.nextToken();
            System.out.println(token);
        }

        System.out.println("------------------------------");

        str = new StringTokenizer(text,delimiter);
        while(str.hasMoreTokens()){
            String token = str.nextToken();
            System.out.println(token);
        }
    }
}
