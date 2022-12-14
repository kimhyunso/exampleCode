package chapter10;

public class CatchByExceptionEx {
    public static void main(String[] args) {
        try{

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("실행 매개값의 수가 부족합니다.");
            System.out.println("[실행 방법]");
            System.out.println("java CatchByExceptionEx num1 num2");
        }catch (NumberFormatException e){
            System.out.println("숫자로 변활할 수 없습니다.");
        }finally {
            System.out.println("다시 실행하세요");
        }
    }
}
