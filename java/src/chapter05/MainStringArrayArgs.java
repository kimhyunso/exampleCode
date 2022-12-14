package chapter05;

public class MainStringArrayArgs {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("프로그램 사용법");
            System.out.println("Java MainStringArrayArgument num1 num2");
            System.exit(0);
        }

        int strNum1 = Integer.parseInt(args[0]);
        int strNum2 = Integer.parseInt(args[1]);

        int result = strNum1 + strNum2;

        System.out.println(strNum1+" + "+strNum2+" = "+result);
    }

}
