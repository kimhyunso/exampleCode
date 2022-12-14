package chapter11.example;

public class StringBuilder {
    public static void main(String[] args) {
        String str = "";
        for(int i=1; i<=100; i++){
            str += i;
        }
        System.out.println(str);

        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for(int i=1; i<=100; i++){
            sb.append(i);
        }
        str = sb.toString();
        System.out.println(str);



    }
}
